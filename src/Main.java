import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    List<Candidate> candidates;
    List<Seat> seats;

    public Main(List<Candidate> candidates, List<Seat> seats) {
        this.candidates = candidates;
        this.seats = seats;
    }

    public void allocateSeats() {
        // Sort the candidates based on their merit
        candidates.sort((c1, c2) -> c2.id - c1.id);

        // Allocate seats to candidates based on their preferences and merit
        for (Candidate candidate : candidates) {
            for (int seatId : candidate.preferences) {
                Seat seat = seats.get(seatId - 1);
                if (seat.isAvailable()) {
                    seat.allocate();
                    System.out.println("Seat " + seat.id + " allocated to Candidate " + candidate.id);
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        List<Candidate> candidates = new ArrayList<>();
        candidates.add(new Candidate(1, Arrays.asList(2, 1, 3))); // Candidate 1 prefers seat 2, then 1, then 3
        candidates.add(new Candidate(2, Arrays.asList(3, 2, 1))); // Candidate 2 prefers seat 3, then 2, then 1
        candidates.add(new Candidate(3, Arrays.asList(1, 2, 3))); // Candidate 3 prefers seat 1, then 2, then 3

        List<Seat> seats = new ArrayList<>();
        seats.add(new Seat(1, 2)); // Seat 1 has capacity 2
        seats.add(new Seat(2, 1)); // Seat 2 has capacity 1
        seats.add(new Seat(3, 2)); // Seat 3 has capacity 2

        Main allocation = new Main(candidates, seats);
        allocation.allocateSeats();
    }
}