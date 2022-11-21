package Train.CompanyWorker;

import Train.CompanyWorker.Service.Service;

public class Main {


    public static void main(String[] args) {
        Service service = new Service();
        Worker worker = service.createWorker();

        System.out.println(worker.toString());

        service.workerUp(worker);
        System.out.println(worker.toString());

        service.workerDown(worker);

        System.out.println(worker.toString());
    }
}
