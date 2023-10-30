package src.dcnr;

class TrieNode {
    private static final int apb = 26 ;
    private TrieNode[] trieNode = new TrieNode[apb] ;
    private int end ;
    private String word ;

    TrieNode()
    {
        for(int i=0 ; i<apb ; i++)
        {
            trieNode[i] = null ;
        }
        end = 0 ;
        word = "" ;
    }

    public TrieNode[] getTrieNode() {
        return trieNode;
    }

    public void setTrieNode(TrieNode[] trieNode) {
        this.trieNode = trieNode;
    }

    public int isEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        word = word;
    }
}

public class Trie {
}
