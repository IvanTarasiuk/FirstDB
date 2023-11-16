package main.java;
public class Main {
    public static void main(String[] args) {
        FirstConnect connect = new FirstConnect();
        String select = """
                select *
                from audit_department;
                """;

        String[][] obj = connect.allSelect(select);

        System.out.println("----------------------------------------------------------");
        System.out.printf("|%-18s|%-18s|%-18s| \n", "Ревизионный номер", "Тип изделия", "Адрес расположения");
        System.out.println("----------------------------------------------------------");

        for (int i = 0; i < obj.length; i++) {
            for (int j = 0; j < obj[0].length; j++) {
                System.out.printf("|%-18s", obj[i][j]);
            }
            System.out.print("| \n");
            System.out.println("----------------------------------------------------------");
        }
    }
}
