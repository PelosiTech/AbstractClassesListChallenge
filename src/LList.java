public class LList implements NodeList {

    private ListItem head = null;

    public LList(ListItem head) {
        this.head = head;
    }

    @Override
    public ListItem getHead() {
        return this.head;
    }

    @Override
    public boolean addItem(ListItem newItem) {
        if(this.head == null){
            //List had nothing in it. This is now the head of the list.
            this.head = newItem;
            return true;
        }

        ListItem currentItem = this.head;
        while (currentItem != null) {
            int flag = (currentItem.compareTo(newItem)); {
                if(flag < 0) { //this flag tells us that the newItem is greater, move next if possible
                    if(currentItem.next() != null) {
                        currentItem = currentItem.next;
                    } else {
                        //nothing is next, so insert newItem at end of our list
                        //because our setNext method returns the ListItem we can use code like this
                        currentItem.setNext(newItem).setPrevious(currentItem);
                        return true;
                    }
                } else if (flag > 0) {
                    //newItem is less, move previous
                    if (currentItem.previous != null) {
                        currentItem.previous.setNext(newItem).setPrevious(currentItem.previous);
                        newItem.setNext(currentItem).setPrevious(newItem);
                    } else {
                        // the node with a previous is the head
                        newItem.setNext(this.head).setPrevious(newItem);
                        this.head = newItem;
                    }
                    return true;
                } else {
                    //equal
                    System.out.println(newItem.getValue() + " is already in the list, it has not been added");
                    return false;
                }
            }
        }
        return false;
    }

    @Override
    public boolean removeItem(ListItem item) {
        if(item != null) {
            System.out.println("Deleting item " + item.getValue());
        }
        ListItem currentItem = this.head;
        while(currentItem != null) {
            int flag = currentItem.compareTo(item);
            if(flag == 0) {
                //item is found
                if (currentItem == this.head) {
                    this.head = currentItem.next;
                } else {
                    currentItem.previous().setNext(currentItem.next());
                    if (currentItem.next != null) {
                        currentItem.next().setPrevious(currentItem.previous());
                    }
                }
                return true;
            } else if (flag < 0) {
                currentItem = currentItem.next();
            } else { //flag > 0
                // The item is not in the list since we are "greater" than the point we need to delete
                return false;
            }
        }
        //We have reached the end of the list without finding the item to delete
        return false;
    }

    @Override
    public void traverse(ListItem head) {
        if (head == null) {
            System.out.println("The list is empty"); }
        else {
            while (head != null) {
                System.out.println(head.getValue());
                head = head.next;
            }
        }
    }
}
