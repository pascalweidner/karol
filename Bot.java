import javakarol.Roboter;
import javakarol.Welt;

import java.util.ArrayList;

public class Bot extends Roboter {
    public Bot(int startX, int startY, char startBlickrichtung, Welt inWelt) {
        super(startX, startY, startBlickrichtung, inWelt);
        this.VerzoegerungSetzen(0);
    }

    public ArrayList<Pair<Integer, Integer>> look(){
        ArrayList<Pair<Integer, Integer>> cords = new ArrayList<>();
        char blickRichtung = this.BlickrichtungGeben();
        for(int i = 0; i < 4; i++) {
            if(!this.IstZiegel() && !this.IstWand()) {
                this.Schritt();
                if(!this.IstMarke()) {
                    Pair<Integer, Integer> k = new Pair<>(this.PositionXGeben(), this.PositionYGeben());
                    cords.add(k);
                }
                this.LinksDrehen();
                this.LinksDrehen();
                this.Schritt();
                this.LinksDrehen();
                this.LinksDrehen();
            }
            this.RechtsDrehen();
        }

        while(blickRichtung != BlickrichtungGeben()) {
            this.RechtsDrehen();
        }

        return cords;
    }



    public void depthSearch(int endX, int endY) {
        ArrayList<Pair<Integer, Integer>> used = new ArrayList<>();
        while(true) {
            this.MarkeSetzen();
            ArrayList<Pair<Integer, Integer>> pairs = look();
            if(pairs.size() == 0) {
                used.remove(0);
                Pair<Integer, Integer> p = used.get(0);
                if(p.getX() > this.PositionXGeben()) {
                    while(!this.IstBlickOsten()) {
                        this.RechtsDrehen();
                    }
                }
                else if(p.getX() < this.PositionXGeben()) {
                    while(!this.IstBlickWesten()) {
                        this.RechtsDrehen();
                    }
                }
                else if(p.getY() > this.PositionYGeben()) {
                    while(!this.IstBlickSueden()) {
                        this.RechtsDrehen();
                    }
                }
                else if(p.getY() < this.PositionYGeben()) {
                    while(!this.IstBlickNorden()) {
                        this.RechtsDrehen();
                    }
                }
                this.Schritt();
                continue;
            }
            Pair<Integer, Integer> pair = pairs.get(0);
            used.add(0, pair);
            if(pair.getX() > this.PositionXGeben()) {
                while(!this.IstBlickOsten()) {
                    this.LinksDrehen();
                }
            }
            else if(pair.getY() > this.PositionYGeben()) {
                while(!this.IstBlickSueden()) {
                    this.LinksDrehen();
                }
            }
            else if(pair.getX() < this.PositionXGeben()) {
                while(!this.IstBlickWesten()) {
                    this.LinksDrehen();
                }
            }
            else {
                while(!this.IstBlickNorden()) {
                    this.LinksDrehen();
                }
            }

            if(pairs.size() != 0) {
                this.Schritt();
            }
            if(this.PositionXGeben() == endX && this.PositionYGeben() == endY) {
                break;
            }
        }
    }
}
