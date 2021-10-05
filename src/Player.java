public class Player {
    /**
     * Instantiate player name + start budget
     */
    String m_name;
    int m_budget;
    public void setPlayer(String name, int budget){
        m_name=name;
        m_budget=budget;
        System.out.println(name+" has "+budget+"$");
    }
    public String getName(){
        return m_name;
    }
    public int getBudget(){
        return m_budget;
    }
}
