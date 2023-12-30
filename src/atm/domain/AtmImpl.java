package atm.domain;
 
import atm.contract.Card;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.io.*;
 
public class AtmImpl implements Serializable, atm.contract.Atm {
    private static final String dataFileName = "Atm.dat";
    private ArrayList<Card> cards;
 
    private Card currentCard;
 
    private Navigation navigation;
 
    public AtmImpl(){
        this.currentCard = null;
        this.cards = new ArrayList<Card>();
        this.navigation = new Navigation();
    }
 
    @Override
    public void start() throws AtmOperationException {
        System.out.println("Starting ATM...");
        this.loadAtmCards();
        System.out.println("ATM Started");
    }
 
    @Override
    public Card login(int accountNo, int pin) throws AtmOperationException{
        Card card = this.findAtmCard(accountNo);
        if(null == card) {
            throw new AtmOperationException("Card not found");
        }
        if (card.getPin() != pin) {
            throw new AtmOperationException("Wrong password");
        }
        this.currentCard = card;
        System.out.println("Login completed => Card :" + this.currentCard);
        return card;
    }
 
    @Override
    public void logout() {
        this.currentCard = null;
        System.out.println("Logout completed => Card :" + this.currentCard);
    }
    @Override
    public Card getCurrentCard() {
        return this.currentCard;
    }
 
    public Card findAtmCard(int accountNo) {
        return this.cards.stream()
            .filter(c -> c.getAccount().getAccountNo() == accountNo)
            .findFirst()
            .orElse(null);
    }
 
    @Override
    public void registerAtmCard(Card atmCard) throws AtmOperationException {
        this.cards.add(atmCard);
        this.saveAtmCards();
        this.currentCard = atmCard;
        System.out.println("Card registered => Card :" + atmCard);
    }
 
    @Override
    public void depositAtmCard(Card atmCard, long amount) throws AtmOperationException {
        atmCard.deposit(amount);
        this.saveAtmCards();
        System.out.println("Deposit operation is completed => Card :" + atmCard);
    }
 
    @Override
    public void withdrawAtmCard(Card atmCard, long amount) throws AtmOperationException {
        atmCard.withdraw(amount);
        this.saveAtmCards();
        System.out.println("Withdraw operation is completed => Card :" + atmCard);
    }
 
    @Override
    public void changeAtmCardPin(Card atmCard, int newPin) throws AtmOperationException {
        atmCard.setPin(newPin);
        this.saveAtmCards();
        System.out.println("Pin changed => Card :" + atmCard);
    }
 
    public void saveAtmCards() throws AtmOperationException {
        String dataFilePath = this.ensureDataFileExists();
        try (FileOutputStream fileAtmCards = new FileOutputStream(dataFilePath);
        ObjectOutputStream outputAtmCards = new ObjectOutputStream(fileAtmCards)) {
            for (int i = 0; i < cards.size(); i++) {
                outputAtmCards.writeObject(cards.get(i));
            }
        } catch (FileNotFoundException e) {
            throw new AtmOperationException(e);
        } catch (IOException e) {
            throw new AtmOperationException(e);
        }
    }
 
    public void loadAtmCards() throws AtmOperationException {
        String dataFilePath = this.ensureDataFileExists();
        try (FileInputStream fileAtmCards = new FileInputStream(dataFilePath);
            ObjectInputStream inputAtmCards = new ObjectInputStream(fileAtmCards)) {
 
            boolean endOfFile = false;
            while (!endOfFile) {
                try {
                    CardImpl card = (CardImpl) inputAtmCards.readObject();
                    System.out.println(card.toString());
                    this.cards.add(card);
                } catch (EOFException e) {
                    endOfFile = true;
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (FileNotFoundException e) {
            throw new AtmOperationException(e);
        } catch (EOFException e) {
            System.out.println("This is new ATM");
        } catch (IOException e) {
            throw new AtmOperationException(e);
        }
    }
 
    private String ensureDataFileExists() throws AtmOperationException {
        String workingDirectoryPath = Paths.get("").toAbsolutePath().toString();
 
        String dataFilePath = workingDirectoryPath + "/data/" + dataFileName;
        File dataFile = new File(dataFilePath);
        if (!dataFile.exists()) {
            try {
                Path directory = Files.createDirectories(Paths.get(workingDirectoryPath + "/data"));
                Path file = Files.createFile(Paths.get(dataFilePath).toAbsolutePath());
            } catch (IOException e) {
                throw new AtmOperationException(e);
            }
        }
        return dataFilePath;
    }
 
    @Override
    public Navigation getNavigation() {
        return navigation;
    }
}