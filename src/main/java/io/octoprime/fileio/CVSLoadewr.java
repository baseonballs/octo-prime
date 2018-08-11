package io.octoprime.fileio;

public class CVSLoadewr {

    /*
yearID,teamID,lgID,playerID,salary
1985,ATL,NL,barkele01,870000
1985,ATL,NL,bedrost01,550000
1985,ATL,NL,benedbr01,545000
1985,ATL,NL,campri01,633333
1985,ATL,NL,ceronri01,625000
     */
    private void process() {
        String filename = "";
        //   int[] arr = new String[10];

        /*
        Pattern pattern = Pattern.compile(",");
        try (BufferedReader in = new BufferedReader(new FileReader(filename));){
            List<Player> players = in
                    .lines()
                    .skip(1)
                    .map(line -> {
                        String[] arr = pattern.split(line);
                        return new Player(Integer.parseInt(arr[0]),
                                arr[1],
                                arr[2],
                                arr[3],
                                Integer.parseInt(arr[4]));
                    })
                    .collect(Collectors.toList());
        }
        */
    }
}

/*
public class Player {
    private int year;
    private String teamID;
    private String teamID;
    private String lgID;
    private String playerID;
    private int salary;
    // defined getters and setters here
}
*/