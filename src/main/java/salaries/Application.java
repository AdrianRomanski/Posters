package salaries;

import java.util.*;

public class Application {

    // Max size of input based on exercise
    private static final int MAX_SIZE = 1_000_000;

    // index of bosses[] is workerNumber and value is directBoss - if its value is equal to totalWorkers+1 it mean
    // that we have a salary for this worker from input
    static int[] bosses = new int[MAX_SIZE];

    // index of salaries[] is workerNumber and value its salary
    static int[] salaries = new int[MAX_SIZE];

    // directSubordinates[] contains count of direct subordinates(obviously)
    // so if a person have one 1 subordinate and that subordinate have 2 subordinates the result will be [1] not 3 neither 2
    static int[] directSubordinates = new int[MAX_SIZE];

    // queue[] contains workerNumbers we need to process
    static int[] queue = new int[MAX_SIZE];

    // index of totalSubordinates[] is a worker number and values is total number of subordinates so it contains
    // subordinates of children
    static int[] totalSubordinates = new int[MAX_SIZE];

    // index of singularSubordinate[] is worker number
    // value 0 means - it have no children's or is a director
    // value -1 means - it have more than one children
    // value > 0 means - that's the singular subordinate workerNumber
    static int[] singularSubordinate = new int[MAX_SIZE];

    // index of usedSalaries[] is salary
    // value == 0 mean that nobody holds this salary
    // value > 0 is index of worker with this salary
    static int[] usedSalaries = new int[MAX_SIZE];

    static int totalWorkers = 0;
    static int tail = 0;
    static int pointer = 0;


    public static void main(String[] args) {
        algorithm();
    }


    /**
     This method is taking input from console
     1 input is a count of totalWorkers in company
     2 input is a boss of worker
     3 input is a salary we know
     */
    private static void initPrincipalsAndSalaries() {
        Scanner scanner = new Scanner(System.in);

        // Scanning for number of employees
        totalWorkers = scanner.nextInt();

        // Filling up bosses[] and salaries[]
        for (int i = 1; i <= totalWorkers; i++) {
            // Bosses
            bosses[i] = scanner.nextInt();
            if (bosses[i] == i) {
                // We got the director
                salaries[i] = totalWorkers;
            }
            // Salaries
            salaries[i] = scanner.nextInt();
            if (salaries[i] != 0) {
                // If its not 0 it mean that we got the salary from input
                bosses[i] = totalWorkers + 1;
            }
        }
        totalWorkers++;
        // Setting up bosses[numberOfEmployees+1] to numberOfEmployees+1
        bosses[totalWorkers] = totalWorkers;
        // Setting up salaries[numberOfEmployees+1] to numberOfEmployees+1
        salaries[totalWorkers] = totalWorkers;
    }


    /**
     This method is initializing directSubordinates[]
     and queue[] (not all queue it will grow in countSubordinates())
     */
    private static void initDirectSubordinatesAndQueue() {
        // Filling up directSubordinates with 0
        Arrays.fill(directSubordinates, 0);

        // Every time we find a match - increase by one
        // The result number is a count of total direct subordinates for this person
        // Except director!!!
        for (int i = 0; i < totalWorkers; ++i) {
            // Example we have 4 numbers 11 in positions [1]/[2]/[4]/[5]
            // Result will be ranks[11] = 4
            directSubordinates[bosses[i]] += 1;
        }

        // If in directSubordinates[] we find "0" we take the index and put in in queue[]
        // After that increment tail variable
        for (int i = 0; i <= totalWorkers; i++) {
            if (directSubordinates[i] == 0) {
                queue[tail++] = i;
            }
        }
    }


    /**
     This method is counting total number of Subordinates for worker
     */
    private static void countSubordinates() {
        // We are looping until "queue" have no more items
        while (pointer < tail) {
            // Temp variable is value that had 0 ranks
            int temp = queue[pointer++];
            int principal = bosses[temp];
            // We are checking if salary of this worker is equal to 0
            if (salaries[temp] == 0) {
                // That step is a key by deducting one if same value from principals appears more times we can catch it
                directSubordinates[principal]-=1;
                if (directSubordinates[principal] == 0) {
                    // Another key is here - making queue bigger when we have a match
                    // (looping more times - condition pointer < tail)
                    queue[tail++] = principal;
                }
                // Counting number of subordinates
                totalSubordinates[principal] += totalSubordinates[temp] + 1;
            }
        }
    }


    /**
     This method is finding Salaries that already belongs to some worker
     and then store them in usedSalaries[]. Also it is specifying if subordinate is Singular
     */
    private static void findUsedSalariesAndSingularSubordinates() {
        for (int i = 1; i < totalWorkers; ++i) {   //2
            // If salary is bigger than 0 (So it exist) put the value in array
            if (salaries[i] != 0) {
                // Index is equal to salary that we found and value is index of salaries
                usedSalaries[salaries[i]] = i;
            // If its not 0 it mean that it already have subordinate
            } else if (singularSubordinate[bosses[i]] == 0) {
                // That mean we found direct singular subordinate
                singularSubordinate[bosses[i]] = i;
            } else {
                // Setting it to -1 because of 2 subordinates - we can't specify salary
                singularSubordinate[bosses[i]] = -1;
            }
        }
    }


    /**
     This method is assigning salaries to workers  based on direct boss salary
     and also salaries to usedSalaries
     */
    public static void algorithm() {
        initPrincipalsAndSalaries();
        initDirectSubordinatesAndQueue();
        countSubordinates();
        findUsedSalariesAndSingularSubordinates();

        int i = 0;
        int numberOfFree = 0;
        int numberOfPossible = 0;

        while (i < totalWorkers - 1) {
            // If usesSalaries[i + 1] == 0 it mean that salary is not specified
            while (i < totalWorkers - 1 && usedSalaries[i + 1] == 0) {
                // Moving to  worker that match the condition by incrementing i
                ++i;
                // index of usedSalaries[] is actually the salary that's used(!= 0) or not(==0) and value is worker number
                numberOfFree++;
                numberOfPossible++;
            }
            // If usesSalaries[i + 1] == 0 it mean that salary is specified so we can try to specify salary of children
            while (i < totalWorkers - 1 && usedSalaries[i + 1] != 0) {
                // Moving to  worker that match the condition by incrementing i
                ++i;
                // index of usedSalaries[] is actually the salary that's used(!= 0) or not(==0) and value is worker number
                int workerNumber = usedSalaries[i];
                int salary = i;
                numberOfFree -= totalSubordinates[workerNumber];
                if (numberOfFree == 0) {
                    while (numberOfPossible > 0 && singularSubordinate[workerNumber] > 0) {
                        // Decrementing number of possibilities if salary is not greater than zero (and with first loop)
                        numberOfPossible--;
                        while (usedSalaries[salary] > 0) {
                            --salary;
                        }
                        // here workerNumber becomes a singularSubordinateNumber of this worker
                        workerNumber = singularSubordinate[workerNumber];
                        // it meets all the condition to set up the salary
                        salaries[workerNumber] = salary;
                        // and we can store it as usedSalary
                        usedSalaries[salary] = workerNumber;
                    }
                }
                if (totalSubordinates[workerNumber] != 0) {
                    numberOfPossible = 0;
                }
            }
        }
        for (int j = 0; j < totalWorkers; j++)
            System.out.println(totalSubordinates[j]);

        // Printing final result
        for (int j = 1; j < totalWorkers; j++)
            System.out.println(salaries[j]);
    }
}
