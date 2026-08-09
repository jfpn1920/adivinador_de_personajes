import java.util.Random;
import java.util.Scanner;
public class adivinador_de_personajes {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Random aleatorio = new Random();
        String[] personajes = {"Mario", "Batman", "Spider-Man", "Superman", "Sonic"};
        String[] categorias = {"Videojuegos", "Comics", "Comics", "Comics", "Videojuegos"};
        String[] profesiones = {"Plomero", "Superheroe", "Superheroe", "Superheroe", "Velocista"};
        int opcion;
        int personajeSeleccionado = -1;
        boolean partidaIniciada = false;
        boolean acertado = false;
        //---------------------------------------------//
        //--|menu_principal_adivinador_de_personajes|--//
        //---------------------------------------------//
        do {
            System.out.println("menu principal adivinador de personajes");
            System.out.println("1) Iniciar partida");
            System.out.println("2) Mostrar pista");
            System.out.println("3) Adivinar personaje");
            System.out.println("4) Mostrar resultado");
            System.out.println("5) Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = entrada.nextInt();
            entrada.nextLine();
            switch (opcion) {
                //---------------------//
                //--|iniciar_partida|--//
                //---------------------//
                case 1:
                    personajeSeleccionado = aleatorio.nextInt(personajes.length);
                    partidaIniciada = true;
                    acertado = false;
                    System.out.println("Partida iniciada.");
                    System.out.println("Se ha seleccionado un personaje secreto.");
                    break;
                //-------------------//
                //--|mostrar_pista|--//
                //-------------------//
                case 2:
                    if (!partidaIniciada) {
                        System.out.println("Primero debes iniciar una partida.");
                        break;
                    }
                    System.out.println("Pista 1 | Categoria: " + categorias[personajeSeleccionado]);
                    System.out.println("Pista 2 | Profesion: " + profesiones[personajeSeleccionado]);
                    break;
                //------------------------//
                //--|adivinar_personaje|--//
                //------------------------//
                case 3:
                    if (!partidaIniciada) {
                        System.out.println("Primero debes iniciar una partida.");
                        break;
                    }
                    System.out.print("Ingrese el nombre del personaje: ");
                    String respuesta = entrada.nextLine();
                    if (respuesta.equalsIgnoreCase(personajes[personajeSeleccionado])) {
                        acertado = true;
                        System.out.println("Respuesta correcta.");
                    } else {
                        System.out.println("Respuesta incorrecta.");
                    }
                    break;
                //-----------------------//
                //--|mostrar_resultado|--//
                //-----------------------//
                case 4:
                    if (!partidaIniciada) {
                        System.out.println("No existe una partida iniciada.");
                    } else if (acertado) {
                        System.out.println("Resultado: Ganaste.");
                        System.out.println("El personaje era: " + personajes[personajeSeleccionado]);
                    } else {
                        System.out.println("Resultado: Aun no has acertado.");
                        System.out.println("El personaje era: " + personajes[personajeSeleccionado]);
                    }
                    break;
                //------------------------------//
                //--|salir_del_menu_principal|--//
                //------------------------------//
                case 5:
                    System.out.println("Gracias por jugar Adivinador de Personajes.");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        } while (opcion != 5);
        entrada.close();
    }
}