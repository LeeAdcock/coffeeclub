public void main(String, args[])
{
    BlackjackGame game = new BlackjackGame();
    String inputName = System.in.readln;
    
    do 
    {
        game.addPlayer(inputName);
    } while(null !=(input = System.in.readln));
    while(!game.isOver())
    {
        for(player player: game.get Players())
        {
            if(player.cardTotal() < 16)
                game.giveCard(player)
        }
    }
    System.out.println("Winner" + game.getWinner().getName());
}