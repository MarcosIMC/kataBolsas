# TypeScript Kata Setup

Includes:

- ✅ JUnit
- 🕵️ Mockito

## Setup

1. [Create a new repository](https://github.com/new?template_name=kata-setup-typescript&template_owner=AgileCraftsmanshipCanarias) from this template
2. Clone it and open with IntelliJ
3. Configure SDK
   1. File > Project Structure.
   2. Set "SDK" 17
   3. Set Language Level "SDK Default"
4. Configure Gradle
   1. Settings > Build, Execution, Deployment > Build Tools > Gradle
   2. Set Gradle JVM to 17

# Clases

- Backpack 
  - Guarda : arraylist de artículos
  + estoy_lleno
  + eliminar_articulo
  + añadir_articulo
- Bolsa
  - Guarda : arraylist de artículos
  - Categoría : string
  + estoy_lleno
  + eliminar_articulo
  + añadir_articulo
- Artículo
  - Nombre : string
  - Categoría : string
- Persona
   - Backpack backpack
   - ArrayList<Bolsa> bolsas
   + meter_articulo_backpack
   + meter_articulo_bolsa
   + organizar_alfabeticamente