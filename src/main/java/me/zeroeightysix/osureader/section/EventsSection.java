package me.zeroeightysix.osureader.section;

import me.zeroeightysix.osureader.node.OsuNode;
import me.zeroeightysix.osureader.node.OsuPrimitiveNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 086 on 16/05/2018.
 */
public class EventsSection {
    String backgroundFile;
    List<Break> breaks = new ArrayList<>();

    public EventsSection(OsuSection section) {
        for (OsuNode node : section.getEntries()) {
            if (node instanceof OsuPrimitiveNode) {
                Object o = node.getValue();
                if (o instanceof List) {
                    List list = (List) o;
                    switch (list.size()) {
                        case 3: // Break period
                            try {
                                breaks.add(new Break(((Number) list.get(1)).longValue(), ((Number) list.get(2)).longValue()));
                            }catch (Exception ignored){} // invalid formatting
                            break;
                        case 5: // Background and video effects
                            this.backgroundFile = list.get(2).toString();
                            break;
                    }
                }
            }
        }
    }

    public List<Break> getBreaks() {
        return breaks;
    }

    public String getBackgroundFile() {
        return backgroundFile;
    }

    public static class Break {
        private final long start;
        private final long end;

        public Break(long start, long end) {
            this.start = start;
            this.end = end;
        }

        public long getStart() {
            return start;
        }

        public long getEnd() {
            return end;
        }

        @Override
        public String toString() {
            return "Break(" + getStart() + "," + getEnd() + ")";
        }
    }
}
