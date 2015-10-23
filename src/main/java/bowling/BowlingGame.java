package bowling;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.common.collect.Lists;

public class BowlingGame {
    public int computeScore(String inputScore) {
        char[] chars = inputScore.toCharArray();
        int i = 0;
        List<String> frameScores = Lists.newArrayList();
        while (i < chars.length) {
            StringBuilder frameBuilder = new StringBuilder();
            frameBuilder.append(chars[i]).append(chars[i+1]);
            frameScores.add(frameBuilder.toString());
            i+= 2;
        }
        return frameScores.stream()
            .map(Frame::new)
            .reduce(Frame::sum)
                //TODO CBO virer le reduce et iterer 2 frame par 2 frame
            .orElse(new Frame("00")).getTotalScore();
    }
}
