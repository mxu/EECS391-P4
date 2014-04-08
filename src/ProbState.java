public class ProbState {
    private boolean _seen;   // if this tile has been in sight range of the agent's units
    private float _pDanger;  // probability that this tile is in range of a tower or contains an obstacle
    private int _visits;     // number of times a peasant has been on this tile
    private int _hits;       // number of times a peasant has been hit on this tile

    public ProbState() {
        _seen = false;
        _pDanger = 1;
        _visits = 0;
        _hits = 0;
    }

    public void see() { _seen = true; }
    public boolean seen() { return _seen; }

    public void setPDanger(float prob) { _pDanger = prob; }
    public float pDanger() { return _pDanger; }

    public void visit() { _visits++; }
    public float visits() { return _visits; }

    public void hit() { _hits++; }
    public float hits() { return _hits; }
}
