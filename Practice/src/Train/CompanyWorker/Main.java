package Train.CompanyWorker;

import Train.CompanyWorker.Service.Service;

public class Main {
    public static void main(String[] args) {
        Service service = new Service();
        Worker worker = service.createWorker();

        service.workerUp(worker);
        service.workerDown(worker);
    }
}
