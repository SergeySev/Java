package Train.CompanyWorker.Service;

import Train.CompanyWorker.DB.DB;
import Train.CompanyWorker.Position;
import Train.CompanyWorker.Worker;

import java.util.Scanner;

public class Service {
    DB db = new DB();
    public Worker createWorker() {
        Scanner scanner = new Scanner(System.in);

        Worker newWorker = new Worker();
        System.out.println("Name: ");
        newWorker.setName(scanner.nextLine());
        System.out.println("Surname: ");
        newWorker.setSurName(scanner.nextLine());
        System.out.println("Position: ");

        newWorker.setPosition(switch (scanner.nextLine()) {
            case "Top" -> Position.TOP;
            case "SeniorTomato" -> Position.SENIORTOMATO;
            case "Middle" -> Position.MIDDLE;
            case "Junior" -> Position.JUNIOR;
            default -> Position.JUNIOR;
        });

        System.out.println("Salary: ");
        newWorker.setSalary(scanner.nextInt());

        db.addToDB(newWorker);
        return newWorker;
    }

    public void workerUp(Worker worker) {
        if (worker.getPosition() == Position.TOP) {
            System.out.println("Already top");
        } else worker.setPosition(Position.values()[worker.getPosition().ordinal() - 1]);
        db.lookDB();
    }

    public void workerDown(Worker worker) {
        if (worker.getPosition() == Position.JUNIOR) {
            System.out.println("Already jun");
        } else worker.setPosition(Position.values()[worker.getPosition().ordinal() + 1]);
        db.lookDB();
    }
}
