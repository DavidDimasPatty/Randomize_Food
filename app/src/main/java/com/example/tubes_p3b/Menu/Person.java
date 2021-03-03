package com.example.tubes_p3b.Menu;

public class Person {
    private String name;
    private String bahan;
    private String resto;
    private String cara;

    public Person(String name, String bahan, String resto,String cara) {
        this.bahan = bahan;
        this.name = name;
        this.resto = resto;
        this.cara=cara;
    }


    public String getBahan() {
        return bahan;
    }

    public void setBahan(String bahan) {
        this.bahan = bahan;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResto() {
        return resto;
    }

    public void setResto(String resto) { this.resto = resto; }


    public String getcara() {
        return cara;
    }

    public void setcara(String cara) { this.resto = cara; }
}
