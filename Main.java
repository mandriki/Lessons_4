package taskBankomat;

public class Main {

    public static void main(String[] args) {
        Bancomat maney = new Bancomat(); /**Создал обьект*/
        String inpMoney = maney.inputMoney(530);  /** ввел сумму для снятия*/
        System.out.println(inpMoney);
        String outMoney = maney.outputMoney(5,3,2); /** ввел колл. купюр для пополнения*/
        System.out.println(outMoney);
    }
    public static class Bancomat { /**Класс описавающий банкомат*/
        int nominal20, nominal50, nominal100;  /**Наминал купюр*/
        int summa, b100;                               /**Коллчичество денег к выдаче*/
        String res = "не равную 0 и 30";
        int numberBills100, numberBills50, numberBills20;                     /**Колличество купюр наминалом*/

        public Bancomat() {         /** конструктор колличество купюр одного наминала*/
            this.nominal20 = 20;
            this.nominal50 = 50;
            this.nominal100 =100;
            this.summa = 8010;          /** хочу денег столько*/
        }
        /** Метод выдачи купюр*/
            public String inputMoney(int summa) {
                if (summa % 100 == 80 || summa % 100 == 30) {numberBills20 = 2;}
                if (summa % 100 == 60 || summa % 100 == 10){numberBills20 = 1;}
                if (summa == 0 || summa == 30) { System.out.println("Введите правильную суммму");
                    } else {
                        numberBills100 = (summa - nominal50 * numberBills50 - nominal20 * numberBills20) / nominal100;   /** сотен к выдаче*/
                        numberBills50 = (summa - nominal100 * numberBills100 - nominal20 * numberBills20) / nominal50;   /** 50 к выдаче*/
                        numberBills20 = (summa - nominal100 * numberBills100 - nominal50 * numberBills50) / nominal20; /** 20 к выдаче*/
                        res = "Выдало СУММУ: " + summa + " рублей (по 100 - " + numberBills100 + ", по 50 - " + numberBills50 + ", по 20 - " + numberBills20 + ")";
                    }
                return res;
            }
            /** Метод внесения денег в банкомат*/
            public String outputMoney(int numberBills20, int numberBills50, int numberBills100) {
                int[] nominal20 = new int[numberBills20];                   /**  в массиве 2 купюры по 20*/
                    for (int i = 0; i < numberBills20; i++) {
                    nominal20[i] = 20;                                      /** заполнение массива*/
                    }
                int nominal20nal = nominal20.length*20;                     /** сколько в наличии*/
                System.out.println("В кошельке по 20 р - "+ (nominal20nal/20));   /** проверка денег в массвиве*/
                int[] nominal50 = new int[numberBills50];
                    for (int i = 0; i < numberBills50; i++) {
                    nominal50[i] = 50;
                    }
                int nominal50nal = nominal50.length*50;
                System.out.println("В кошельке по 50 р - "+ (nominal50nal/50));   /** проверка денег в массвиве*/
                int[] nominal100 = new int[numberBills100];
                    for (int i = 0; i < numberBills100; i++) {
                    nominal100[i] = 100;
                    }
                int nominal100nal = nominal100.length*100;
                System.out.println("В кошельке по 100 р - "+ (nominal100nal/100));   /** проверка денег в массвиве*/
                int summa = nominal20nal + nominal50nal + nominal100nal;
            return "ИТОГО денег внесено: " + summa + "p. (По 20 р - "+ nominal20nal+") (По 50 р - "+ nominal50nal+") (По 100 р - "+ nominal100nal+")";
            }
    }
}

