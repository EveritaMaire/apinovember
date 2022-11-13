package apinovember.stepdefinitions;

import apinovember.domain.Board;
import apinovember.helpers.TestCaseContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;

import static apinovember.client.TrelloClient.getBoardInfo;
import static apinovember.conctance.ProjectConstants.BOARD_ID;
import static apinovember.conctance.ProjectConstants.BOARD_NAME;

public class TrelloSteps {

    @Given("The board exists and contains the correct interaction")
    public void getBoardAndCheckInfo(){
        Response response = getBoardInfo(BOARD_ID);
        Board board = response.as(Board.class);
        TestCaseContext.setBoard(board);
        //System.out.println(board.getName());

        Assertions.assertThat(board.getId())
                .as("We check that the board id is correct")
                .isEqualTo(BOARD_ID);
        Assertions.assertThat(board.getName())
                .as(" We check that board name is correct")
                .isEqualTo(BOARD_NAME);

    }
    @When("I change the board title to {string}")
    public void iChangeBoardTitle(String title){
        System.out.print(" The name is change to " + title);
        Board board = TestCaseContext.getBoard();
        System.out.println(board.getName());
        System.out.println(board.getId());
    }
    @When("I check that board name was updated to {string}")
    public void iCheckBoard(String title){
        System.out.print(" The name is updated to " + title);
    }

    @When("I add list with title {string} to the board")
    public void iAddList(String title){
        System.out.print(" I created list with name " + title);
    }
    @When("I delete newly created list")
    public void iDeleteTheList(){
        System.out.print("The list is deleted!");
    }
}
