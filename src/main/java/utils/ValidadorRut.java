package utils;

public class ValidadorRut {

    public static boolean validarRut(String rut) {
        String digitoRut = tomarDigito(rut);
        String rutSinDigito = tomarNumeros(rut);
        String digitoCalculado;
        if(validarNumeros(rutSinDigito)){
            digitoCalculado = calculoDigitoVerificador(rutSinDigito);
        }else{
            return false;
        }
        return validarDigito(digitoRut,digitoCalculado);
    }

    private static String tomarDigito(String rut) {
        return rut.substring(rut.length()-1);
    }

    public static String tomarNumeros(String rut) {
        rut = rut.replace(".","");
        rut = rut.replace("-","");
        return rut.substring(0,rut.length()-1);
    }

    public static boolean validarNumeros(String rutSinDigito) {
        int numeroRut;
        boolean validador = true;
        try{
            numeroRut = Integer.parseInt(rutSinDigito);
        }catch (Exception e){
            System.out.println("Ingrese números válidos");
            validador = false;
        }
        return validador;
    }

    private static boolean validarDigito(String digitoRut, String digitoCalculado) {
        if (digitoCalculado.equals(digitoRut)){
            return true;
        }else{
            System.out.println("Ingrese un rut válido");
            return false;
        }
    }

    public static String calculoDigitoVerificador(String rutSinDigito) {
        String palabraRutInvertida = invertirOrden(rutSinDigito);
        int[] arregloRut = generarArregloRut(palabraRutInvertida);
        multiplicarDigitos(arregloRut);
        int sumaRut = sumarMultiplicaciones(arregloRut);
        double dividirRut = dividirResultados(sumaRut);
        int multiplicacionEntera = tomarDecimales(dividirRut);
        int restaRut = restarResultados(sumaRut,multiplicacionEntera);
        return obtenerDigitoVerificador(restaRut);
    }

    public static String invertirOrden(String rutSinDigito) {
        StringBuilder stringBuilder = new StringBuilder(rutSinDigito);
        return stringBuilder.reverse().toString();
    }

    private static int[] generarArregloRut(String palabraRutInvertida) {
        int[] arregloCaracteres = new int[palabraRutInvertida.length()];
        for (int i = 0; i < arregloCaracteres.length; i++) {
            arregloCaracteres[i] = Integer.parseInt(String.valueOf(palabraRutInvertida.charAt(i)));
        }
        return arregloCaracteres;
    }

    private static void multiplicarDigitos(int[] arregloCaracteres) {
        int[] cadena = {2,3,4,5,6,7};
        int contador = 0;
        for (int i = 0; i < arregloCaracteres.length; i++) {
            if(contador == cadena.length){
                contador = 0;
            }
            arregloCaracteres[i] *= cadena[contador];
            contador++;
        }
    }

    private static int sumarMultiplicaciones(int[] arregloCaracteres) {
        int sumaArregloRut = 0;
        for (int i = 0; i < arregloCaracteres.length; i++) {
            sumaArregloRut += arregloCaracteres[i];
        }
        return sumaArregloRut;
    }

    private static double dividirResultados(int sumaArregloRut) {
        return sumaArregloRut/11;
    }

    private static int tomarDecimales(double divisionSumas) {
        return ((int)divisionSumas)*11;
    }

    private static int restarResultados(int sumaMultiplicaciones, int multSinDecimales) {
        return Math.abs(sumaMultiplicaciones - multSinDecimales);
    }

    private static String obtenerDigitoVerificador(int restaNumeros) {
        String digitoVerificador = String.valueOf(11 - restaNumeros);
        if(digitoVerificador.equals("10")){
            digitoVerificador = "k";
        }else if(digitoVerificador.equals("11")){
            digitoVerificador = "0";
        }
        return digitoVerificador;
    }
}
