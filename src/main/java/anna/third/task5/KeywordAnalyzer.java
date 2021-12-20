package anna.third.task5;


public abstract class KeywordAnalyzer implements TextAnalyzer {
    abstract protected String[] getKeywords();

    abstract protected Label getLabel();

    public Label processText(String s) {
        for (String keyword : getKeywords()) {
            if (s.contains(keyword))
                return getLabel();
        }
        return Label.OK;
    }
}
