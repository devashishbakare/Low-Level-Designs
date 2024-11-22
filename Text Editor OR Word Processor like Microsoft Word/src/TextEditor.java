import java.util.*;
public class TextEditor {
    private List<List<CharacterWithStyle>> document;
    private Map<Character, Style> charWithStyleMapper;

    public void init(){
        document = new ArrayList<>();
        charWithStyleMapper = new HashMap<>();
    }

    public void addCharacter(int row, int column, char ch,
                        String fontName, int fontSize,
                        boolean isBold, boolean isItalic){

        //Added row if there isn't

        while(document.size() <= row){
            document.add(new ArrayList<>());
        }
        List<CharacterWithStyle> documentCurrentRow = document.get(row);
        if(documentCurrentRow.size() < column){
            while(documentCurrentRow.size() < column){
                documentCurrentRow.add(null);
            }
        }
        Style style = charWithStyleMapper.computeIfAbsent(ch, v -> new Style(fontName, fontSize, isBold, isItalic));
        documentCurrentRow.add(column, new CharacterWithStyle(ch, style));
    }

    public String getStyle(int row, int col){

        if(document.size() < row || document.get(row).size() < col) return "";

        CharacterWithStyle characterWithStyle = document.get(row).get(col);
        char ch = characterWithStyle.character;
        Style style = characterWithStyle.style;

        return ch + "-" + style.fontName + "-" + style.fontSize + "-" + (style.isBold ? "b" : "") + "-" + (style.isItalic ? "i" : "");

    }

    public String readLine(int row){
        if(document.size() < row) return "";
        StringBuilder sb = new StringBuilder();

        List<CharacterWithStyle> rowCharacters = document.get(row);
        for(CharacterWithStyle characterWithStyle : rowCharacters){
            if(characterWithStyle != null){
                sb.append(characterWithStyle.character);
            }
        }
        return sb.toString();
    }

    public boolean deleteCharacter(int row, int col){
        if(document.size() < row || document.get(row).size() < col) return false;
        document.get(row).remove(col);
        return true;
    }

}
