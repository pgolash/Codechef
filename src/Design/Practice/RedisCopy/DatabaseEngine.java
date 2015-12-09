package Design.Practice.RedisCopy;

/**
 * Created by prashantgolash on 11/4/15.
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class DatabaseEngine {

    private HashMap<String,String> database;
    private HashMap<Integer, Integer> reverseDatabase;
    private List<String> transactionBlock;
    private Stack<List<String>> transactionStack;
    private Boolean begin, rollback;

    /**
     * Constructs a new Database object.
     */
    public DatabaseEngine() {
        database = new HashMap<String,String>();
        reverseDatabase = new HashMap<Integer, Integer>();
        transactionBlock = new ArrayList<String>();
        transactionStack = new Stack<List<String>>();
        begin = false;
        rollback = true;
    }

    // Main class responsible for processing command
    public String processCommand(String user_command) {
        String output = "";
        DBCommand commandC1 = DBCommand.formCommand(user_command);

        if (commandC1 == null)
            return output;

        String tempC1 = commandC1.getCommand();

        if ( tempC1.equals("GET")) {
            output += (this.get(commandC1.getParameters().get(0)) + "\n");
        }
        if (tempC1.equals("SET")){
            this.set(commandC1.getParameters().get(0), commandC1.getParameters().get(1));
        }
        if (tempC1.equals("UNSET")){
            this.unset(commandC1.getParameters().get(0));
        }
        if (tempC1.equals("NUMEQUALTO")){
            output += (this.numequalto(commandC1.getParameters().get(0)) + "\n");
        }
        if (tempC1.equals("END")){
            this.end();
        }
        if (tempC1.equals("BEGIN")){
            this.begin();
        }
        if (tempC1.equals("ROLLBACK")){
            output += this.rollback();
        }
        if (tempC1.equals("COMMIT")){
            this.commit();
        }
        return output;
    }

    protected String get(String variableName) {
        String temp = database.get(variableName);
        if (temp != null)
            return temp;
        return "NULL";
    }

    /**
     * Stores a variable name and its corresponding value.
     *
     * @param variable_name variable name to add to  database
     * @param value string value that will be mapped to variable_name
     */
    protected void set(String variable_name, String value) {
        String tempValue = database.get(variable_name);
        String revCommand = "";
        Integer temp_counter = 0;

        //Check if variable_name is already in database.
        if (tempValue == null) {
            database.put(variable_name, value);
            revCommand = "UNSET " + variable_name;
        }
        //If overwriting value then adjust count reverseDatabase and generate reverse command
        else {
            temp_counter = reverseDatabase.get(Integer.parseInt(tempValue));
            reverseDatabase.put(Integer.parseInt(tempValue), temp_counter - 1);
            database.put(variable_name, value);
            revCommand = "SET " + variable_name + " " + tempValue;
        }
        //Add to current transactional block
        if (begin && rollback)
            transactionBlock.add(revCommand);

        //Update count accordingly to our reverse hashmap.
        temp_counter = reverseDatabase.get(Integer.parseInt(value));
        if (temp_counter != null) {
            reverseDatabase.put(Integer.parseInt(value), ++temp_counter);
        }
        else {
            reverseDatabase.put(Integer.parseInt(value), 1);
        }
    }


    /**
     * Delete given variable from the database.
     *
     * @param variable_name variable to delete
     */
    protected void unset(String variable_name){
        String temp_value = database.get(variable_name);
        Integer temp_counter = null;
        String rev_command = "";

        if (temp_value != null ) {
            database.remove(variable_name);
            temp_counter = reverseDatabase.get(Integer.parseInt(temp_value));
            reverseDatabase.put(Integer.parseInt(temp_value), --temp_counter); //Adjust count

            if (begin && rollback) {
                rev_command = "SET " + variable_name + " " + temp_value;
                transactionBlock.add(rev_command);
            }
        }
        else
            System.err.println("Variable: " + variable_name + ", couldn't be unset because it doesn't exist in your database.");

    }


    /**
     * Return the total number of variables associated with a value.
     *
     * @param value value to use for lookup
     * @return the number of variables that contain the given value
     */
    protected int numequalto(String value) {
        Integer temp_counter = reverseDatabase.get(Integer.parseInt(value));
        if (temp_counter != null)
            return temp_counter;
        return 0;
    }


    /**
     * Start a new transaction block, that can be reversed if necessary.
     *
     */
    protected void begin(){
        if (!begin)
            begin = true;
        else {
            if (!transactionBlock.isEmpty()) {
                transactionStack.push(transactionBlock);
                transactionBlock = new ArrayList<String>();
            }
        }

    }

    /**
     * Make current transaction block irreversible.
     *
     */
    protected void commit(){
        begin = false;
        transactionStack.removeAllElements();
    }

    /**
     * Reverse all the commands in the current transactional block.
     *
     * @return a string containing "INVALID ROLLBACK" if transaction can't be reversed or "" if success
     */
    protected String rollback(){
        if (begin){
            Collections.reverse(transactionBlock);

            //Reverse changes.
            rollback = false; //The reverse commands don't get placed in a transaction block.
            for (String c1: transactionBlock)
                processCommand(c1);

            rollback = true;

            //Switch current transactional block to element in stack.
            try {
                transactionBlock = transactionStack.pop();
            }
            //No more transactional blocks so every command is committed.
            catch (EmptyStackException e) {
                begin = false;
            }
        }
        else
            return ("INVALID ROLLBACK\n");
        return "";
    }

    /**
     * Commits all transactional blocks and ends the program (i.e return null).
     *
     * @return returns null to calling method
     */
    protected String end(){
        for (int i = 0; i <= transactionStack.size();i++)
            commit();
        return null;
    }
}