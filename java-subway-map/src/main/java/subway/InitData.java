package subway;

import java.util.Arrays;
import java.util.List;

import subway.domain.Line;
import subway.domain.Station;
import subway.repository.LineRepository;
import subway.repository.StationRepository;

public class InitData {
    private static final List<String> stations = Arrays.asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역");
    private static final List<String> lines = Arrays.asList("2호선", "3호선", "신분당선");

    public static void load() {
        stations.forEach(name ->  StationRepository.addStation(new Station(name)));
        lines.forEach(name -> LineRepository.addLine(new Line(name)));
        LineRepository.addStation("2호선", new Station("교대역"));
        LineRepository.addStation("2호선", new Station("강남역"));
        LineRepository.addStation("2호선", new Station("역삼역"));
        LineRepository.addStation("3호선", new Station("교대역"));
        LineRepository.addStation("3호선", new Station("남부터미널역"));
        LineRepository.addStation("3호선", new Station("양재역"));
        LineRepository.addStation("3호선", new Station("매봉역"));
        LineRepository.addStation("신분당선", new Station("강남역"));
        LineRepository.addStation("신분당선", new Station("양재역"));
        LineRepository.addStation("신분당선", new Station("양재시민의숲역"));
    }
}
