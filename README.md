# Sistema de Gestión de Paquetería — TP Integrador SGC (UTN FRSF)

Repositorio correspondiente al Trabajo Práctico Integrador de **Ingeniería y Calidad de Software** (Tema: *Sistemas de Gestión de la Configuración*), aplicando el flujo de trabajo **Gitflow**, integración continua mediante **GitHub Actions** y revisión cruzada de Pull Requests.

## Estructura del Repositorio
* `.github/CODEOWNERS`: Define a los integrantes del equipo responsables de revisar y aprobar los cambios en el repositorio.
* `.github/workflows/ci.yml`: Pipeline de Integración Continua que compila automáticamente el proyecto Java (JDK 17) en cada `push` y `pull_request` hacia `main` y `develop`.
* `.gitignore`: Excluye archivos compilados y configuraciones locales del entorno (`*.class`, `out/`, `bin/`, `.idea/`, `.vscode/`, `.env`).
* `src/Paquete.java`: Modelo principal del dominio con atributos `codigo`, `destino`, `peso` y `estado`. Incluye validaciones de datos en el constructor, cálculo de tarifa base más costo por kilogramo (`calcularCostoEnvio()`), aplicación de descuentos porcentuales (`calcularCostoConDescuento()`), gestión de estados de seguimiento (`actualizarEstado()`) y resumen formateado (`getInfo()`).
* `src/Main.java`: Punto de entrada de la aplicación que instancia un paquete, ejecuta las operaciones de cálculo, descuento y cambio de estado, e imprime los resultados por consola.

## Requisitos, Compilación y Ejecución
* **Requisitos:** Java Development Kit (JDK) 17 o superior.
* **Compilar desde la raíz del proyecto:**
  ```bash
  mkdir -p bin
  javac -d bin src/*.java
  ```
* **Ejecutar la aplicación:**
  ```bash
  java -cp bin Main
  ```

## Flujo de Ramas Utilizado (Gitflow)
* `main`: Rama de producción con versiones etiquetadas (`v1.0.0`, `v1.0.1`, `v1.1.0`).
* `develop`: Rama de integración donde convergen las funcionalidades aprobadas mediante Pull Requests.
* `feature/*`: Ramas creadas desde `develop` para desarrollar cada funcionalidad de forma aislada.
* `release/*`: Ramas creadas desde `develop` para preparar y estabilizar una nueva versión antes de llevarla a `main`.
* `hotfix/*`: Ramas creadas desde `main` para corregir errores críticos detectados en producción.

---

## Respuestas Teóricas — Documentación con Git

### 8.a) ¿Qué documentar en el README y por qué versionarlo en el repositorio?
En el archivo `README.md` se debe documentar toda la información esencial para que cualquier desarrollador, docente o colaborador pueda comprender, instalar, compilar y ejecutar el software sin depender de explicaciones externas:
1. **Propósito y alcance del proyecto:** Qué problema resuelve el sistema y cómo está organizada su arquitectura o estructura de carpetas.
2. **Prerrequisitos y dependencias:** Versiones de lenguaje, compilador o herramientas necesarias (en este caso, JDK 17).
3. **Instrucciones de compilación, ejecución y pruebas:** Comandos exactos para levantar el proyecto en un entorno limpio.
4. **Convenciones de trabajo y flujo de ramas:** Reglas de contribución, flujo de ramificación adoptado (Gitflow) y criterios de revisión.

**Importancia de versionar el README:** Al mantener `README.md` bajo control de versiones junto con el código fuente, la documentación evoluciona de forma sincronizada con cada versión del software. Cada *tag* o *release* conserva exactamente las instrucciones válidas para ese estado del código, evitando documentación desactualizada y permitiendo auditar cuándo y por qué cambiaron las especificaciones.

### 8.b) Colaboración externa en un Pull Request: datos solicitados y herramientas de GitHub
Cuando un colaborador externo propone una modificación mediante un Pull Request, el equipo necesita comprender el contexto, el impacto y la validez del cambio antes de integrarlo.

**Datos que se le deben solicitar al colaborador:**
* **Título descriptivo y resumen del cambio:** Qué problema resuelve o qué funcionalidad agrega.
* **Motivación / Issue asociado:** Referencia al incidente o requerimiento que origina la modificación.
* **Detalle técnico de los cambios realizados:** Archivos o módulos afectados y decisiones de diseño tomadas.
* **Pasos para reproducir y probar:** Instrucciones concretas para verificar que el cambio funciona y no introduce regresiones.
* **Confirmación de estándares:** Verificación de que el código compila, respeta las convenciones del proyecto y no incluye archivos temporales o credenciales.

**Herramientas que ofrece GitHub para estandarizar y controlar este proceso:**
* **Pull Request Templates (`.github/PULL_REQUEST_TEMPLATE.md`):** Plantilla en Markdown que se carga automáticamente en la descripción cada vez que alguien abre un PR, asegurando que complete todos los campos requeridos.
* **CODEOWNERS (`.github/CODEOWNERS`):** Asigna automáticamente revisores obligatorios según las rutas de archivos modificadas, garantizando que los responsables del proyecto evalúen el código antes del merge.
* **GitHub Actions (CI):** Ejecuta de manera automática la compilación y pruebas en cada PR, bloqueando visualmente (con checks en rojo) cualquier aporte que rompa el build.
* **Branch Protection Rules (Reglas de protección de ramas):** Permiten exigir aprobaciones mínimas de revisores, checks de CI en verde y prohibir pushes directos sobre `main` y `develop`.
* **Revisión en línea (*Files changed* / *Suggestions*):** Permite comentar líneas específicas de código y sugerir modificaciones puntuales dentro de la interfaz del PR.