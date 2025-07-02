//import java.util.*;
//
//class Athlete {
//    String name;
//    String id;
//    List<String> sports;
//
//    public Athlete(String name, String id, List<String> sports) {
//        this.name = name;
//        this.id = id;
//        this.sports = sports;
//    }
//}
//
//class Match {
//    String sport;
//    String athlete1;
//    String athlete2;
//    String venue;
//    String day;     // e.g., "Day 2"
//    String time;    // e.g., "14:00–15:30"
//
//    public Match(String sport, String athlete1, String athlete2, String venue, String day, String time) {
//        this.sport = sport;
//        this.athlete1 = athlete1;
//        this.athlete2 = athlete2;
//        this.venue = venue;
//        this.day = day;
//        this.time = time;
//    }
//
//    public String getSlot() {
//        return day + ", " + time;
//    }
//}
//
//
//class TournamentManager {
//    Map<String, Athlete> athletes = new HashMap<>();
//    List<Match> matches = new ArrayList<>();
//
//    public void registerAthlete(String name, String id, List<String> sports) {
//        if (athletes.containsKey(id)) {
//            System.out.println("Athlete with ID already registered.");
//            return;
//        }
//        athletes.put(id, new Athlete(name, id, sports));
//        System.out.println("Athlete registered: " + name);
//    }
//
//    public void assignMatch(String sport, String id1, String id2, String venue, String day, String time) {
//        String slot = day + ", " + time;
//
//        // Check if both athletes exist
//        if (!athletes.containsKey(id1) || !athletes.containsKey(id2)) {
//            System.out.println("One or both athletes not found.");
//            return;
//        }
//
//        // Constraint 1: Athletes cannot play multiple matches at same time
//        for (Match m : matches) {
//            if (m.getSlot().equals(slot)) {
//                if (m.athlete1.equals(id1) || m.athlete2.equals(id1) ||
//                        m.athlete1.equals(id2) || m.athlete2.equals(id2)) {
//                    System.out.println("Conflict: Athlete double-booked at same time.");
//                    return;
//                }
//
//                // Constraint 2: Venue cannot be double-booked
//                if (m.venue.equals(venue)) {
//                    System.out.println("Conflict: Venue already booked.");
//                    return;
//                }
//            }
//
//            // Constraint 3: Same sport on same day
//            if (m.day.equals(day)) {
//                if ((m.athlete1.equals(id1) || m.athlete2.equals(id1)) && m.sport.equals(sport)) {
//                    System.out.println("Conflict: " + id1 + " already playing " + sport + " on " + day);
//                    return;
//                }
//                if ((m.athlete1.equals(id2) || m.athlete2.equals(id2)) && m.sport.equals(sport)) {
//                    System.out.println("Conflict: " + id2 + " already playing " + sport + " on " + day);
//                    return;
//                }
//            }
//        }
//
//        matches.add(new Match(sport, id1, id2, venue, day, time));
//        System.out.println("Match scheduled between " + id1 + " and " + id2 + " in " + sport);
//    }
//
//    public void listMatchesByDay(String day) {
//        System.out.println("Matches on " + day + ":");
//        for (Match m : matches) {
//            if (m.day.equals(day)) {
//                System.out.println(m.sport + " - " + m.athlete1 + " vs " + m.athlete2 + " at " + m.venue + " [" + m.time + "]");
//            }
//        }
//    }
//
//    public void listAthletesBySport(String sport) {
//        System.out.println("Athletes in " + sport + ":");
//        for (Athlete a : athletes.values()) {
//            if (a.sports.contains(sport)) {
//                System.out.println(a.name + " (ID: " + a.id + ")");
//            }
//        }
//    }
//
//    public void detectConflicts() {
//        Set<String> slots = new HashSet<>();
//        Set<String> venueSlots = new HashSet<>();
//        Set<String> sportDay = new HashSet<>();
//
//        for (Match m : matches) {
//            String slot = m.getSlot();
//
//            // Athlete conflict
//            String key1 = m.athlete1 + "-" + slot;
//            String key2 = m.athlete2 + "-" + slot;
//
//            if (!slots.add(key1)) {
//                System.out.println("Conflict: " + m.athlete1 + " double-booked at " + slot);
//            }
//            if (!slots.add(key2)) {
//                System.out.println("Conflict: " + m.athlete2 + " double-booked at " + slot);
//            }
//
//            // Venue conflict
//            String venueKey = m.venue + "-" + slot;
//            if (!venueSlots.add(venueKey)) {
//                System.out.println("Conflict: Venue " + m.venue + " double-booked at " + slot);
//            }
//
//            // Same sport in same day
//            String sportKey1 = m.athlete1 + "-" + m.sport + "-" + m.day;
//            String sportKey2 = m.athlete2 + "-" + m.sport + "-" + m.day;
//
//            if (!sportDay.add(sportKey1)) {
//                System.out.println("Conflict: " + m.athlete1 + " playing " + m.sport + " multiple times on " + m.day);
//            }
//            if (!sportDay.add(sportKey2)) {
//                System.out.println("Conflict: " + m.athlete2 + " playing " + m.sport + " multiple times on " + m.day);
//            }
//        }
//    }
//}
//public class hashmap {
//    public static void main(String[] args) {
//        TournamentManager tm = new TournamentManager();
//
//        tm.registerAthlete("Ali", "A01", Arrays.asList("Football", "Tennis"));
//        tm.registerAthlete("Zara", "A02", Arrays.asList("Tennis", "Swimming"));
//        tm.registerAthlete("Hassan", "A03", Arrays.asList("Football", "Badminton"));
//
//        tm.assignMatch("Football", "A01", "A03", "Stadium 1", "Day 1", "10:00–11:00");
//        tm.assignMatch("Tennis", "A01", "A02", "Court 1", "Day 1", "10:00–11:00"); // conflict!
//        tm.assignMatch("Tennis", "A01", "A02", "Court 2", "Day 1", "12:00–13:00"); // OK
//
//        tm.listMatchesByDay("Day 1");
//        tm.listAthletesBySport("Tennis");
//
//        System.out.println("\n--- Conflict Detection ---");
//        tm.detectConflicts();
//    }
//}
import java.util.*;

class Speaker {
    private String name;
    private String email;
    private Set<String> expertise;

    public Speaker(String name, String email, Set<String> expertise) {
        this.name = name;
        this.email = email;
        this.expertise = new HashSet<>(expertise);
    }

    // Getters
    public String getName() { return name; }
    public String getEmail() { return email; }
    public Set<String> getExpertise() { return expertise; }

    public boolean canSpeakOn(String topic) {
        return expertise.contains(topic);
    }
}

class Session {
    private String topic;
    private Speaker speaker;
    private String timeSlot;
    private String room;
    private String day;

    public Session(String topic, Speaker speaker, String timeSlot, String room, String day) {
        this.topic = topic;
        this.speaker = speaker;
        this.timeSlot = timeSlot;
        this.room = room;
        this.day = day;
    }

    // Getters
    public String getTopic() { return topic; }
    public Speaker getSpeaker() { return speaker; }
    public String getTimeSlot() { return timeSlot; }
    public String getRoom() { return room; }
    public String getDay() { return day; }
}

class ConferenceScheduler {
    private Set<Speaker> speakers;
    private List<Session> sessions;
    private Set<String> rooms;

    public ConferenceScheduler() {
        speakers = new HashSet<>();
        sessions = new ArrayList<>();
        rooms = new HashSet<>();
    }

    // Register a new speaker
    public boolean registerSpeaker(String name, String email, Set<String> expertise) {
        // Check if speaker already exists
        for (Speaker s : speakers) {
            if (s.getEmail().equalsIgnoreCase(email)) {
                return false;
            }
        }
        return speakers.add(new Speaker(name, email, expertise));
    }

    // Assign a session with validation
    public boolean assignSession(String topic, String speakerEmail, String timeSlot, String room, String day) {
        // Find speaker
        Speaker speaker = null;
        for (Speaker s : speakers) {
            if (s.getEmail().equalsIgnoreCase(speakerEmail)) {
                speaker = s;
                break;
            }
        }
        if (speaker == null) return false;

        // Validate speaker can speak on this topic
        if (!speaker.canSpeakOn(topic)) return false;

        // Check for speaker time conflicts
        for (Session s : sessions) {
            if (s.getSpeaker().getEmail().equalsIgnoreCase(speakerEmail) &&
                    s.getTimeSlot().equals(timeSlot)) {
                return false;
            }
        }

        // Check for room time conflicts
        for (Session s : sessions) {
            if (s.getRoom().equalsIgnoreCase(room) &&
                    s.getTimeSlot().equals(timeSlot)) {
                return false;
            }
        }

        // Check if speaker already presenting same topic
        for (Session s : sessions) {
            if (s.getSpeaker().getEmail().equalsIgnoreCase(speakerEmail) &&
                    s.getTopic().equalsIgnoreCase(topic)) {
                return false;
            }
        }

        // Add the room if new
        rooms.add(room);

        // All checks passed, add session
        sessions.add(new Session(topic, speaker, timeSlot, room, day));
        return true;
    }

    // Query methods
    public List<Session> getSessionsByDay(String day) {
        List<Session> result = new ArrayList<>();
        for (Session s : sessions) {
            if (s.getDay().equalsIgnoreCase(day)) {
                result.add(s);
            }
        }
        return result;
    }

    public List<Session> getSessionsByRoom(String room) {
        List<Session> result = new ArrayList<>();
        for (Session s : sessions) {
            if (s.getRoom().equalsIgnoreCase(room)) {
                result.add(s);
            }
        }
        return result;
    }

    public List<Speaker> getSpeakersByTopic(String topic) {
        List<Speaker> result = new ArrayList<>();
        for (Speaker s : speakers) {
            if (s.canSpeakOn(topic)) {
                result.add(s);
            }
        }
        return result;
    }

    // Conflict detection
    public List<String> detectConflicts() {
        List<String> conflicts = new ArrayList<>();

        // Check for room double bookings
        Map<String, Set<String>> roomTimeSlots = new HashMap<>();
        for (Session s : sessions) {
            roomTimeSlots.putIfAbsent(s.getRoom(), new HashSet<>());
            if (!roomTimeSlots.get(s.getRoom()).add(s.getTimeSlot())) {
                conflicts.add("Room conflict: " + s.getRoom() + " double-booked at " + s.getTimeSlot());
            }
        }

        // Check for speaker time conflicts
        Map<String, Set<String>> speakerTimeSlots = new HashMap<>();
        for (Session s : sessions) {
            String email = s.getSpeaker().getEmail();
            speakerTimeSlots.putIfAbsent(email, new HashSet<>());
            if (!speakerTimeSlots.get(email).add(s.getTimeSlot())) {
                conflicts.add("Speaker conflict: " + s.getSpeaker().getName() +
                        " double-booked at " + s.getTimeSlot());
            }
        }

        // Check for speaker repeating topics
        Map<String, Set<String>> speakerTopics = new HashMap<>();
        for (Session s : sessions) {
            String email = s.getSpeaker().getEmail();
            speakerTopics.putIfAbsent(email, new HashSet<>());
            if (!speakerTopics.get(email).add(s.getTopic())) {
                conflicts.add("Topic conflict: " + s.getSpeaker().getName() +
                        " repeating topic " + s.getTopic());
            }
        }

        return conflicts;
    }

    public static void main(String[] args) {
        ConferenceScheduler scheduler = new ConferenceScheduler();

        // Register speakers
        scheduler.registerSpeaker("Alice", "alice@email.com",
                new HashSet<>(Arrays.asList("AI", "Data Science")));
        scheduler.registerSpeaker("Bob", "bob@email.com",
                new HashSet<>(Arrays.asList("Web", "Cloud")));
        scheduler.registerSpeaker("Charlie", "charlie@email.com",
                new HashSet<>(Arrays.asList("Cybersecurity", "AI")));

        // Schedule sessions
        scheduler.assignSession("AI", "alice@email.com", "10:00-11:00", "Room A", "Day 1");
        scheduler.assignSession("Web", "bob@email.com", "10:00-11:00", "Room B", "Day 1");
        scheduler.assignSession("Data Science", "alice@email.com", "11:00-12:00", "Room A", "Day 1");
        scheduler.assignSession("Cloud", "bob@email.com", "11:00-12:00", "Room B", "Day 1");
        scheduler.assignSession("AI", "charlie@email.com", "14:00-15:00", "Room C", "Day 2");

        // Try to schedule invalid sessions
        boolean conflict1 = scheduler.assignSession("AI", "alice@email.com", "10:00-11:00", "Room C", "Day 1");
        boolean conflict2 = scheduler.assignSession("Web", "bob@email.com", "10:00-11:00", "Room A", "Day 1");
        boolean conflict3 = scheduler.assignSession("AI", "alice@email.com", "15:00-16:00", "Room D", "Day 2");

        System.out.println("Conflicting assignments blocked:");
        System.out.println("Same speaker same time: " + !conflict1);
        System.out.println("Same room same time: " + !conflict2);
        System.out.println("Speaker repeating topic: " + !conflict3);

        // Query examples
        System.out.println("\nDay 1 Sessions:");
        for (Session s : scheduler.getSessionsByDay("Day 1")) {
            System.out.println(s.getTimeSlot() + " " + s.getRoom() + ": " +
                    s.getTopic() + " by " + s.getSpeaker().getName());
        }

        System.out.println("\nAI Speakers:");
        for (Speaker s : scheduler.getSpeakersByTopic("AI")) {
            System.out.println(s.getName() + " (" + s.getEmail() + ")");
        }

        // Detect conflicts
        System.out.println("\nChecking for conflicts:");
        List<String> conflicts = scheduler.detectConflicts();
        if (conflicts.isEmpty()) {
            System.out.println("No conflicts detected");
        } else {
            for (String conflict : conflicts) {
                System.out.println(conflict);
            }
        }
    }
}