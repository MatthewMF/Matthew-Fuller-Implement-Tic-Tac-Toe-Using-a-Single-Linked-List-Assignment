public class LinkedList {

    private Node head;  // Head of the linked list

    // Constructor to initialize an empty linked list
    public LinkedList() {
        //this.head = null;
        for (int i = 0; i < 9; i++) {this.insertAtEnd("");}

    }

    // Method to insert a new node at the end
    public void insertAtEnd(String data) {
        Node newest = new Node(data);
        if(this.head == null)
        {
            this.head = newest;
        }
        else
        {
            Node current = this.head;
            while(current.next != null)
            {
                current = current.next;
            }
            current.next = newest;
        }
    }

    // Method to update a specific position in the list
    public void updatePosition(int position, String data) {
        Node current = this.head;
        while(current != null && position > 1)
        {
            current = current.next;
            position--;
        }
        if(current != null && current.data.equals("")) {current.data = data;}
        else{System.out.print("Invalid postion!");}
    }

    // Method to get the value at a specific position
    public String getPositionValue(int position) {
        Node current = this.head;
        position--; 
        while(current != null && position > 0)
        {
            current = current.next;
            position--;
        }
        if(current == null) {return "Out of bounds";}
        return current.data;
    }

    // Method to display the Tic Tac Toe board
    public void displayBoard() {
        Node node = this.head;
        int count = 0;
        while(node != null && count < 9)
        {
            if(node.data.equals("")) {System.out.print("- ");}
            else{System.out.print(node.data + " ");}
                count++;
                if(count == 3){System.out.println("");}
                if(count == 6){System.out.println("");}   //every 3 nodes, indent
                node = node.next;
        }
    } 
    
    // Method to check for a win
    public boolean checkWinCondition() { //check each and every win conditon, if at least one is true, return true otherwise return false
        if(!this.getPositionValue(1).equals("")  && (this.getPositionValue(1).equals(this.getPositionValue(2))) && (this.getPositionValue(1).equals(this.getPositionValue(3)))) {return true;}
        else if(!this.getPositionValue(4).equals("") && (this.getPositionValue(4).equals(this.getPositionValue(5))) && (this.getPositionValue(4).equals(this.getPositionValue(6)))) {return true;}
        else if(!this.getPositionValue(7).equals("") && (this.getPositionValue(7).equals(this.getPositionValue(8))) && (this.getPositionValue(7).equals(this.getPositionValue(9)))) {return true;}
        else if(!this.getPositionValue(1).equals("") && (this.getPositionValue(1).equals(this.getPositionValue(4))) && (this.getPositionValue(1).equals(this.getPositionValue(7)))) {return true;}
        else if(!this.getPositionValue(2).equals("") && (this.getPositionValue(2).equals(this.getPositionValue(5))) && (this.getPositionValue(2).equals(this.getPositionValue(8)))) {return true;}
        else if(!this.getPositionValue(3).equals("") && (this.getPositionValue(3).equals(this.getPositionValue(6))) && (this.getPositionValue(3).equals(this.getPositionValue(9)))) {return true;}
        else if(!this.getPositionValue(1).equals("") && (this.getPositionValue(1).equals(this.getPositionValue(5))) && (this.getPositionValue(1).equals(this.getPositionValue(9)))) {return true;}
        else if(!this.getPositionValue(3).equals("") && (this.getPositionValue(3).equals(this.getPositionValue(5))) && (this.getPositionValue(3).equals(this.getPositionValue(7)))) {return true;}
        return false;
    }

    // Method to check if the board is full (for draw condition)
    public boolean isBoardFull() {
        for (int i = 1; i < 10; i++)
        {
            if(this.getPositionValue(i).equals("")) {return false;} 
        } 
        return true;
    }
    

    // Method to reset the board
    public void resetBoard() {
        Node current = this.head;
        while(current != null)
        {
            current.data = ("");
            current = current.next;
        }
        
    }
}
