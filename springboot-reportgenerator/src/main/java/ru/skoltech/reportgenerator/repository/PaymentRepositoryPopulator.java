package ru.skoltech.reportgenerator.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import ru.skoltech.reportgenerator.model.Bank;
import ru.skoltech.reportgenerator.model.ContrAgent;
import ru.skoltech.reportgenerator.model.Customer;
import ru.skoltech.reportgenerator.model.Payment;

import java.io.*;
import java.util.Date;

/**
 * @author rost.
 */
@Slf4j
@Component
public class PaymentRepositoryPopulator implements ApplicationListener<ApplicationReadyEvent> {

    private CrudRepository<Bank, String>bankRepo;
    private CrudRepository<Customer, String>customerRepo;
    private CrudRepository<ContrAgent, String>contAgentRepo;
    private CrudRepository<Payment, String> paymentRepo;
    private ClassLoader classloader = Thread.currentThread().getContextClassLoader();

    @Autowired
    public PaymentRepositoryPopulator(CrudRepository<Bank, String>bankRepo,
                                      CrudRepository<Customer, String>customerRepo,
                                      CrudRepository<ContrAgent, String>contAgentRepo,
                                      CrudRepository<Payment, String> paymentRepo) {
        log.info("Initialize123");
        this.bankRepo = bankRepo;
        this.customerRepo = customerRepo;
        this.contAgentRepo = contAgentRepo;
        this.paymentRepo = paymentRepo;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        if( bankRepo.count() == 0){
            saveBank();
        }
        if( customerRepo.count() == 0 )
            saveCustomer();
        if( contAgentRepo.count() == 0)
            saveContAgent();
        if( paymentRepo.count() == 0)
            savePayment();

    }

    public void savePayment(){
        try {
            BufferedReader reader;
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(
                    new File(classloader.getResource("bills.csv").getFile())
            )));


            String line;

            while ((line = reader.readLine()) != null) {
                String[]record = line.split(",");
                Payment payment = new Payment();
                payment.setId(record[0]);
                payment.setName(record[1]);
                //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm_dd:MM:yyyy", Locale.ENGLISH);
                //LocalDate localDate = LocalDate.parse(record[3], formatter);
                //payment.setDate(Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));

                payment.setDate(new Date());

                payment.setContrAgent(contAgentRepo.findById(record[4]).get());
                payment.setBank(bankRepo.findById(record[5]).get());
                payment.setCustomer(customerRepo.findById(record[6]).get());
                payment.setOperationType(record[7]);
                payment.setSumm(Float.parseFloat(record[9]));
                payment.setStatus(record[10]);
                paymentRepo.save(payment);

            }

            reader.close();
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }
    }

    public void saveContAgent(){
        try {
            File file = new File(classloader.getResource("payers.csv").getFile());
            BufferedReader reader;
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String line;

            while ((line = reader.readLine()) != null) {
                String[]record = line.split(",");
                ContrAgent customer = new ContrAgent();
                customer.setId(record[0]);
                customer.setName(record[1]);
                contAgentRepo.save(customer);
            }

            reader.close();
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }
    }
    public void saveCustomer(){
        try {
            File file = new File(classloader.getResource("recipients.csv").getFile());
            BufferedReader reader;
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));


            String line;

            while ((line = reader.readLine()) != null) {
                String[]record = line.split(",");
                Customer customer = new Customer();
                customer.setId(record[0]);
                customer.setName(record[1]);
                customerRepo.save(customer);
            }

            reader.close();
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }
    }

    public void saveBank(){
        try {
            File file = new File(classloader.getResource("banks.csv").getFile());
            BufferedReader reader;
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));


            String line;

            while ((line = reader.readLine()) != null) {
                String[]record = line.split(",");
                Bank bank = new Bank();
                bank.setId(record[0]);
                bank.setName(record[1]);
                bankRepo.save(bank);
            }

            reader.close();
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }
    }


}
