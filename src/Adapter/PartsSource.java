package Adapter;

import java.util.List;

public interface PartsSource {
    List<String> getCPUs();
    List<String> getMemories();
    List<String> getStorages();
    List<String> getGraphicsCards();
    List<String> getOtherParts();
}
