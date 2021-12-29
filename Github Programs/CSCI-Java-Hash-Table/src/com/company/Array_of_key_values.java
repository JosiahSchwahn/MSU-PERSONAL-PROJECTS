package com.company;

public class Array_of_key_values {


    //hash table of Key value objects
    Key_values myArray[];
    //keeps track of hash table size
    int arraySize;
    //keeps track of data in hash table
    int data_amount;

    double load_factor = .80;

    //creates the hash table of objects with the given array size
    public Array_of_key_values(int array_size){
        
        arraySize = array_size;
        
        myArray = new Key_values[array_size];

        data_amount = 0;
        
    }

    //gets called with the int key value and returns the index value in the key_value object hash table
    public int hashFunction(int key){

        int index_value = key % arraySize;

        return index_value;

    }

    //add method to place object in the object hash table with it's given key value
    public void add(Key_values key){

        //takes key value and gets the index value by calling has function
        int code = hashFunction(key.getKey());

        //finds an empty spot in the hash table to place the new key value object in the array
        if (myArray[code] == null) {

            myArray[code] = new Key_values(key.getKey(), key.getName());

            data_amount += 1;

        }
        //collusion (linear probing)
        else if(myArray[code] != null){

            for(int i = code + 1; i != code; i++){

                if(i== arraySize){

                    i = 0;

                }

                if(myArray[i] == null){

                    myArray[i] = new Key_values(key.getKey(), key.getName());

                    data_amount += 1;

                    break;
                }
            }
        }
        //checks if the array needs a rehash by taking the amount of data in the array divded by the hash size.
        // IF this is greater than .80 (our load factor) then the hash table gets rehashed.
        if((double)(data_amount / arraySize) >= load_factor){
            this.rehash();
        }
    }
    //rehash method used to create a new key value hash table that is double the size of the old array and then places
    // the old values in the array with their new index values (since the array size changed their location will change)
    public void rehash(){
        //finds the value which is double the size of the current hash table
        int newSize = arraySize * 2;
        //creates new hash table with the
        Array_of_key_values newHash = new Array_of_key_values(newSize);

        for(int i = 0; i < arraySize; i++){

            if(this.myArray[i] != null){

                newHash.add(myArray[i]);
            }
        }
        //sets the new size of the hash table
        arraySize = newSize;

        this.myArray = newHash.myArray;
    }
    //printing, format
    public void print(){

        for (int i = 0; i < arraySize; i++){

            if(myArray[i] != null){

                String name = myArray[i].getName();

                String key = Integer.toString(myArray[i].getKey());

                System.out.println("Name: " + name + " Key: " + key);

            } else{
                //if nothing is there prints "null object"
                System.out.println("Null Object");
            }
        }
    }
    //delete method that finds the object located at the key value and replaces it with a dummy node
    public void delete(int key_value){

        for(int i = 0; i < arraySize; i++){

            if(myArray[i] != null) {

                if (myArray[i].getKey() == key_value) {

                    System.out.println("Deleting: " + myArray[i].getKey() + " " + myArray[i].getName());

                    Key_values dummy = new Key_values(-1, "Dummy");

                    myArray[i] = dummy;

                }
            }
        }
    }
    //search method used to find the object with the corresponding key value
    public String get(int key_value){

        for(int i = 0; i < arraySize; i ++){

            if((myArray[i] != null)){

                if(myArray[i].getKey() == key_value){

                   return "Found" + myArray[i].getName() + " at key Value " + key_value + " @ Index Location " + i;
                }
            }
        }
        return null;
    }
}
