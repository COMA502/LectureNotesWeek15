package edu.dmacc.dsmcode.coma510.examples.regex;

public class Regex {
    public static void main(String[] args) {
        String taxIdPattern = "\\d{2,3}-\\d{2}-\\d{4}</input><script>do something</script>";
        String gregsTaxId = " 111-11-1111";
        if(!gregsTaxId.trim().matches(taxIdPattern)) {
            System.out.println("Error, not a valid tax ID... :'(");
        }

        String emailPattern = "";
    }
}
