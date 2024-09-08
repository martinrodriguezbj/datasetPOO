import requests
import json
import re
from pathlib import Path

API_KEY = ""
URL = "https://api.openai.com/v1/chat/completions"
HEADERS = {
    "Authorization": f"Bearer {API_KEY}",
    "Content-Type": "application/json"
}


def leer_archivo(ruta: Path) -> str:
    """Lee un archivo y devuelve su contenido como string."""
    try:
        return ruta.read_text(encoding='utf-8')
    except FileNotFoundError:
        print(f"Error: Archivo no encontrado en {ruta}")
        return ""
    except Exception as e:
        print(f"Error al leer el archivo {ruta}: {e}")
        return ""


def obtener_especificacion(escenario: str) -> str:
    """Obtiene la especificación del archivo especificacion.md de un escenario específico."""
    script_dir = Path(__file__).resolve().parent
    ruta_especificacion = script_dir / escenario / 'especificacion.md'
    return leer_archivo(ruta_especificacion)


def obtener_implementacion(escenario: str) -> str:
    """Recorre todos los archivos .java en el directorio del escenario y devuelve su contenido concatenado."""
    ruta_clases = Path(escenario) / "src/main/java/ar/edu/unlp/info" / escenario
    contenido_clases = []

    for archivo_java in ruta_clases.glob("*.java"):
        contenido = leer_archivo(archivo_java)
        if contenido:
            contenido_clases.append(f"\n// Contenido del archivo {archivo_java.name}\n{contenido}")

    return ''.join(contenido_clases)


def generar_prompt(especificacion: str, implementacion: str) -> str:
    """Genera el prompt basado en el archivo plantilla y reemplaza los marcadores."""
    script_dir = Path(__file__).resolve().parent
    ruta_prompt = script_dir / 'promptTemplate.md'
    prompt = leer_archivo(ruta_prompt)

    # Reemplazar los placeholders
    prompt = prompt.replace("{especificacion}", especificacion)
    prompt = prompt.replace("{implementación}", implementacion)
    
    return prompt


def enviar_a_gpt(prompt: str) -> str:
    """Envía el prompt a la API de OpenAI y procesa la respuesta."""
    data = {
        "model": "gpt-4",
        "messages": [
            {"role": "user", "content": prompt}
        ],
        "temperature": 0.5,
    }

    try:
        response = requests.post(URL, headers=HEADERS, data=json.dumps(data))
        response.raise_for_status()  # Lanza una excepción para respuestas de error HTTP
        return response.json().get("choices", [])[0].get("message", {}).get("content", "")
    except requests.exceptions.RequestException as e:
        print(f"Error en la petición: {e}")
        return ""


def extraer_bloques_codigo(respuesta: str) -> list:
    """Extrae los bloques de código de la respuesta de GPT, buscando primero entre acentos graves y luego entre triples comillas dobles."""
    # Buscar bloques de código rodeados por acentos graves
    bloques = re.findall(r'```(.*?)```', respuesta, re.DOTALL)
    
    if not bloques:
        # Si no se encontraron bloques con acentos graves, buscar entre triples comillas dobles
        bloques = re.findall(r'"""\s*([\s\S]*?)\s*"""', respuesta, re.DOTALL)
    
    bloques_limpios = []
    
    for bloque in bloques:
        lineas = bloque.split('\n')
        # Si la primera línea es 'java', eliminarla
        if lineas and lineas[0].strip() == 'java':
            lineas.pop(0)
        bloque_limpio = '\n'.join(lineas).strip()
        bloques_limpios.append(bloque_limpio)
    
    return bloques_limpios

def extraer_nombre_clase(codigo: str) -> str:
    """Extrae el nombre de la clase del bloque de código Java."""
    # Buscar la declaración de la clase en el código
    match = re.search(r'class\s+(\w+)', codigo)
    if match:
        return match.group(1)
    return "NombreClaseDesconocido"


def guardar_codigo(escenario: str, codigo: str, idx: int):
    """Guarda el bloque de código en un archivo .java dentro de la dirección src/test/java/ar/edu/unlp/info/escenario."""
    nombre_clase = extraer_nombre_clase(codigo)
    directorio_destino = Path(escenario) / "src/test/java/ar/edu/unlp/info" / escenario
    directorio_destino.mkdir(parents=True, exist_ok=True)
    ruta_archivo = directorio_destino / f"{nombre_clase}.java"
    
    try:
        ruta_archivo.write_text(codigo, encoding='utf-8')
        print(f"Bloque de código {idx} guardado en {ruta_archivo}")
    except Exception as e:
        print(f"Error al guardar el bloque de código {idx} en {ruta_archivo}: {e}")


def procesar_escenario(escenario: str):
    """Procesa un escenario específico y obtiene su especificación, implementación y respuesta de GPT."""
    especificacion = obtener_especificacion(escenario)
    implementacion = obtener_implementacion(escenario)

    if not especificacion or not implementacion:
        print(f"No se pudo obtener la especificación o implementación para el {escenario}.")
        return

    prompt = generar_prompt(especificacion, implementacion)
    print(f"Prompt generado para {escenario}:\n{prompt}")
    print("\n" + "=" * 80 + "\n")

    respuesta_gpt = enviar_a_gpt(prompt)

    if respuesta_gpt:
        bloques_codigo = extraer_bloques_codigo(respuesta_gpt)
        if bloques_codigo:
            for idx, bloque in enumerate(bloques_codigo, 1):
                print(f"Código {idx} en {escenario}:\n{bloque}\n")
                guardar_codigo(escenario, bloque, idx)
        else:
            print(f"No se encontraron bloques de código en la respuesta de {escenario}.")
            #igualmente, imprimo la respuesta de GPT
            print(f"Respuesta de GPT para {escenario}:\n{respuesta_gpt}")
    else:
        print(f"Error: No se recibió respuesta válida de GPT para {escenario}.")


def main():
    """Función principal del script."""
    # Iterar sobre los 10 escenarios
    for i in range(6, 11):
        escenario = f"escenario{i:02d}"
        print(f"Procesando {escenario}...\n")
        procesar_escenario(escenario)


if __name__ == "__main__":
    main()
