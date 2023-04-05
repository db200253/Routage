package Graphique;

import java.awt.BorderLayout;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.layout.springbox.implementations.LinLog;
import org.graphstream.ui.swing_viewer.SwingViewer;
import Ressources.Artere;
import Ressources.Commutateur;
import Ressources.Interface;
import Ressources.Machine;

@SuppressWarnings("serial")
public class Fenetre extends JFrame {

    private Graph graph;
    private SwingViewer viewer;
    List<Commutateur> lc = new ArrayList<>();
    List<Artere> la = new ArrayList<>();
    List<Machine>[] lm;

    @SuppressWarnings("unchecked")
    public Fenetre(Interface reseau) {
        super("Réseau");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Création du graph
        graph = new SingleGraph("Réseau");

        lc = reseau.getListC();
        la = reseau.getListA();
        lm = new ArrayList[reseau.getListC().size()];

        for(int i = 0; i < reseau.getListC().size(); ++i) {

            lm[i] = new ArrayList<Machine>();
            lm[i].addAll(reseau.getListC().get(i).getList());
        }

        // Ajout des commutateurs
        for (Commutateur s : lc) {
            Node node = graph.addNode(s.getNomCommutateur());
            node.setAttribute("ui.label", s.getNomCommutateur());
            node.setAttribute("ui.class", "switch");
        }
        
        int edgeCount = 0; // initialisation du compteur pour les arêtes
        
        // Ajout des arêtes entre les commutateurs
        for (int i = 0; i < lc.size(); i++) {
            Commutateur s1 = lc.get(i);
            for (int j = i + 1; j < lc.size(); j++) {
                Commutateur s2 = lc.get(j);
                for (Artere a : la) {
                    if ((a.getC1().equals(s1) && a.getC2().equals(s2))
                            || (a.getC1().equals(s2) && a.getC2().equals(s1))) {
                        graph.addEdge("Arête" + edgeCount, s1.getNomCommutateur(), s2.getNomCommutateur());
                        edgeCount++;
                        break;
                    }
                }
            }
        }

        // Ajout des machines et des arêtes
        for (int i = 0; i < lc.size(); i++) {
            Commutateur s = lc.get(i);
            for (int j = 0; j < lm[i].size(); j++) {
                Machine m = lm[i].get(j);
                Node node = graph.addNode(m.getNomMachine());
                node.setAttribute("ui.label", m.getNomMachine());
                node.setAttribute("ui.class", "machine");
                graph.addEdge("Arête " + edgeCount, s.getNomCommutateur(), m.getNomMachine());
                edgeCount++; // incrémentation du compteur pour les arêtes
            }
        }

        // Style du graph
        graph.setAttribute("ui.stylesheet", "node.machine { fill-color: red; size:20px;} " +
                "node.switch { shape: box; fill-color: blue; size:20px;}" +
                "edge { shape: line; }");

        // Calcul du layout
        LinLog layout = new LinLog();


        // Viewer
        viewer = new SwingViewer(graph, SwingViewer.ThreadingModel.GRAPH_IN_ANOTHER_THREAD);
        viewer.enableAutoLayout(layout); // activation du layout automatique
        Component view2 = (Component) viewer.addDefaultView(false);
        add(view2, BorderLayout.CENTER);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
