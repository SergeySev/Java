package Train.Constructor;

public class Constructor {
    /*
     Написать простой класс с полями, и связать его с другим классом через конструктор
     */

    public static class CarConstruct {
        /*
        Создать переменные - из чего состоит машина, запчасти
         */
        private String kuzov;
        private String color;
        private boolean salon; // true - skin; false - fabric
        private boolean korobkaPeredach; // true - ручная, false - автомат

        private final int wheels = 4;
        private String dvigatel;
        private Insurense insurense;

        public CarConstruct(String kuzov, String color, boolean salon, boolean korobkaPeredach, String dvigatel, Insurense insurense) {
            this.kuzov = kuzov;
            this.color = color;
            this.salon = salon;
            this.korobkaPeredach = korobkaPeredach;
            this.dvigatel = dvigatel;
            this.insurense = new Insurense();
        }

        public CarConstruct(String color, boolean salon) {
            this.color = color;
            this.salon = salon;
            this.insurense = new Insurense();
        }

        public CarConstruct() {
        }

        public String getKuzov() {
            return kuzov;
        }

        public void setKuzov(String kuzov) {
            this.kuzov = kuzov;
        }

        public Insurense getInsurense() {
            return insurense;
        }
    }
    public static void main(String[] args) {
        CarConstruct bmw = new CarConstruct("speed-car", "red", true, false, "Super", new Insurense());

        System.out.println(bmw.getInsurense().getPerMonth());
        bmw.getInsurense().setPerMonth(999);
        System.out.println(bmw.getInsurense().getPerMonth());
    }
}
