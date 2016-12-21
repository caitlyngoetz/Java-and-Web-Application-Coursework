
public class NodeFactIFT extends Node {

        private NodeBoolExpr be;
        private NodeStmt stmt1, stmt2;

        public NodeFactIFT(NodeBoolExpr boolexpr, NodeStmt stmt1, NodeStmt stmt2){
        this.be = boolexpr;
        this.stmt1 = stmt1;
        this.stmt2 = stmt2;
    }

        public double eval(Environment env) throws Exception {
                if (be.eval(env) == 1.0) {
                        return stmt1.eval(env);
                } else if (stmt2 != null) {
                        return stmt2.eval(env);
                } else {
                        return 0.0; //false
                }
        }

}
