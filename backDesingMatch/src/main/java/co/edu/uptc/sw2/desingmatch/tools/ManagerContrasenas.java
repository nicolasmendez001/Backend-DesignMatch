package co.edu.uptc.sw2.desingmatch.tools;

public class ManagerContrasenas {

    public static String cifrarContrasena(String txt) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest
                    .getInstance(ConstantesGlobales.HASH_TYPE);
            byte[] array = md.digest(txt.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < array.length; i++) {
                sb.append(Integer.toHexString(0xFF & array[i]));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
            System.err.println("Eror -> " + e);
        }
        return null;
    }
}
