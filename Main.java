import javakarol.Welt;

public class Main {

    public static void main(String[] args) {
        Welt welt = new Welt("D:\\Development\\Languages\\Java\\Karol\\src\\Karolwelten\\12Labyrint.kdw");
        Bot bot = new Bot(1, 1, 'O', welt);
        bot.MarkeLoeschen();
        bot.Schritt();
        bot.MarkeLoeschen();
        bot.LinksDrehen();
        bot.LinksDrehen();
        bot.Schritt();
        bot.LinksDrehen();
        bot.LinksDrehen();
        bot.depthSearch(8, 15);
    }
}
