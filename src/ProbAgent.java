import edu.cwru.sepia.action.Action;
import edu.cwru.sepia.agent.Agent;
import edu.cwru.sepia.environment.model.history.History.HistoryView;
import edu.cwru.sepia.environment.model.state.State.StateView;
import edu.cwru.sepia.environment.model.state.Unit.UnitView;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

public class ProbAgent extends Agent {

    private static final long serialVersionUID = 0L;

    private Integer townhallID;         // townhall id
    private List<Integer> peasantIDs;   // list of peasant ids
    private ProbState probStates[][];   // probability states for each tile

    public ProbAgent(int playernum) {
        super(playernum);
        System.out.println("ProbAgent initialized");
    }

    @Override
    public Map<Integer, Action> initialStep(StateView state, HistoryView stateHistory) {
        // initialize probability states
        int width = state.getXExtent();
        int height = state.getYExtent();
        probStates = new ProbState[width][height];

        for(int id: state.getUnitIds(playernum)) {
            UnitView unit = state.getUnit(id);
            int currHP = unit.getHP();                              // current hp
            int radius = unit.getTemplateView().getSightRange();    // sight radius
            String name = unit.getTemplateView().getName();         // name
            System.out.println(name + ": " + currHP + "HP, " + radius + " range");
        }

        return null;
    }

    @Override
    public Map<Integer, Action> middleStep(StateView state, HistoryView stateHistory) {

        for(int id: state.getAllUnitIds()) {
            UnitView unit = state.getUnit(id);
            int currHP = unit.getHP();                              // current hp
            int visRange = unit.getTemplateView().getSightRange();  // vision range
            int atkRange = unit.getTemplateView().getRange();       // attack range
            String name = unit.getTemplateView().getName();         // name
            System.out.println(name + ": " + currHP + "HP, " + visRange + "V, " + atkRange + "A");
        }

        return null;
    }

    @Override
    public void terminalStep(StateView state, HistoryView stateHistory) {

    }

    @Override
    public void savePlayerData(OutputStream outputStream) { }

    @Override
    public void loadPlayerData(InputStream inputStream) { }
}
