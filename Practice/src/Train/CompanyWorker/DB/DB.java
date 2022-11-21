package Train.CompanyWorker.DB;

import Train.CompanyWorker.Worker;

import java.util.ArrayList;

public class DB {
    ArrayList<Worker> dataBase = new ArrayList<>();

    public void addToDB(Worker worker){
        dataBase.add(worker);
        System.out.println("Data Base");
        System.out.println(toString());
    }

    public void lookDB() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "DB{" +
                "dataBase=" + dataBase +
                '}';
    }
}
