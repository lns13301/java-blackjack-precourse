package domain.manager;

import domain.card.CardFactory;
import domain.user.Player;
import domain.user.Table;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ManagerTest {
    @Test
    void blackjackPlayerTest() {
        Manager manager = new Manager();
        Table table = new Table();
        List<Boolean> bool = new LinkedList<>();
        table.addMember(new Player("tester1", 5000));

        assertThat(table.getTable().size()).isEqualTo(2);

        table.getTable().get(0).addCard(CardFactory.create().get(4));
        table.getTable().get(0).addCard(CardFactory.create().get(32));
        table.getTable().get(0).addCard(CardFactory.create().get(40));

        table.getTable().get(1).addCard(CardFactory.create().get(0));
        table.getTable().get(1).addCard(CardFactory.create().get(40));

        bool.add(false);
        bool.add(true);
        table.setBlackjack(bool);

        manager.processManagementBalance(table);
    }

    @Test
    void blackjackDealerTest() {
        Manager manager = new Manager();
        Table table = new Table();
        List<Boolean> bool = new LinkedList<>();
        table.addMember(new Player("tester1", 5000));

        assertThat(table.getTable().size()).isEqualTo(2);

        table.getTable().get(0).addCard(CardFactory.create().get(0));
        table.getTable().get(0).addCard(CardFactory.create().get(40));

        table.getTable().get(1).addCard(CardFactory.create().get(4));
        table.getTable().get(1).addCard(CardFactory.create().get(32));
        table.getTable().get(1).addCard(CardFactory.create().get(40));

        bool.add(true);
        bool.add(false);
        table.setBlackjack(bool);

        manager.processManagementBalance(table);
    }

    @Test
    void blackjackDrawTest() {
        Manager manager = new Manager();
        Table table = new Table();
        List<Boolean> bool = new LinkedList<>();
        table.addMember(new Player("tester1", 5000));

        assertThat(table.getTable().size()).isEqualTo(2);

        table.getTable().get(0).addCard(CardFactory.create().get(0));
        table.getTable().get(0).addCard(CardFactory.create().get(40));

        table.getTable().get(1).addCard(CardFactory.create().get(1));
        table.getTable().get(1).addCard(CardFactory.create().get(41));

        bool.add(true);
        bool.add(true);
        table.setBlackjack(bool);

        manager.processManagementBalance(table);
    }
}