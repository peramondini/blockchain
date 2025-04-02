import com.google.gson.GsonBuilder;
import java.util.ArrayList;

public class PlutosChain {

    public static ArrayList<Block> blockchain = new ArrayList<Block>();
    public static int difficulty = 5;


    public static void main(String[] args) {
        Block genesisBlock = new Block ("Hi Im the first block","0");
        System.out.println("Trying to mine block 1...");
        blockchain.get(0).mineBlock(difficulty);

        Block secondBlock = new Block("I am the second block" ,genesisBlock.hash );
        System.out.println("Trying to Mine block 2... ");
        blockchain.get(1).mineBlock(difficulty);

        Block thirdBlock = new Block("I am the third block" ,secondBlock.hash );
        System.out.println("Trying to Mine block 3... ");
        blockchain.get(2).mineBlock(difficulty);

        System.out.println("\nBlockchain is Valid: " + isChainValid());

        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
        System.out.println("\nThe block chain: ");
        System.out.println(blockchainJson);
    }
    public static Boolean isChainValid(){
        Block currentBlock;
        Block previuousBlock;

        for (int i=1; 1 < blockchain.size(); i++){
            currentBlock = blockchain.get(i);
            previuousBlock = blockchain.get(i-1);
            //compare registered hash and calculated hash:
            if(!currentBlock.hash.equals(currentBlock.previousHash) ){
                System.out.println("Previous hash not equal");
                return false;
            }
            if(!previuousBlock.hash.equals(currentBlock.previousHash) ){
                System.out.println("Previuos hash not equal");
                return false;
            }

        }
        return true;
    }
}

