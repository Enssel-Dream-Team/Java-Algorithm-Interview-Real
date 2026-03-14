package seonguk.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class P02621 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Card[] cards = new Card[5];
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String color = st.nextToken();
            int number = Integer.parseInt(st.nextToken());
            cards[i] = new Card(color, number);
        }

        int ans;
        if (isRoyalStraight(cards)) {
            ans = 900 + cards[4].number;
        } else if (isFourCard(cards)) {
            int addNum;
            if (cards[0].number == cards[1].number) {
                addNum = cards[0].number;
            } else if (cards[0].number == cards[2].number) {
                addNum = cards[0].number;
            } else {
                addNum = cards[1].number;
            }
            ans = 800 + addNum;
        } else if (isFullHouse(cards)) {
            ans = 700 + 10 * isTriple(cards) + isPair(cards);
        } else if (isFlush(cards)) {
            ans = 600 + cards[4].number;
        } else if (isStraight(cards)) {
            ans = 500 + cards[4].number;
        } else if (isTriple(cards) > 0) {
            ans = 400 + isTriple(cards);
        } else if (isTwoPair(cards)[1] > 0) {
            int[] pair = isTwoPair(cards);
            ans = 300 + 10 * pair[1] + pair[0];
        } else if (isPair(cards) > 0) {
            ans = 200 + isPair(cards);
        } else {
            ans = 100 + cards[4].number;
        }
        System.out.println(ans);
        br.close();
    }

    static boolean isRoyalStraight(Card[] cards) {
        return isFlush(cards) && isStraight(cards);
    }

    static boolean isFourCard(Card[] cards) {
        int[] nums = new int[10];
        for (Card card : cards) {
            nums[card.number]++;
        }
        for (int num : nums) {
            if (num == 4) {
                return true;
            }
        }
        return false;
    }

    static boolean isFullHouse(Card[] cards) {
        return isTriple(cards) > 0 && isPair(cards) > 0;
    }

    static boolean isFlush(Card[] cards) {
        String color = cards[0].color;
        for (int i = 1; i < cards.length; i++) {
            if (!cards[i].color.equals(color)) {
                return false;
            }
        }
        return true;
    }

    static boolean isStraight(Card[] cards) {
        Arrays.sort(cards, Comparator.comparingInt(o -> o.number));

        int num = cards[0].number;
        for (int i = 1; i < cards.length; i++) {
            if (num + 1 != cards[i].number) {
                return false;
            }
            num = cards[i].number;
        }
        return true;
    }

    static int isTriple(Card[] cards) {
        int[] nums = new int[10];
        for (Card card : cards) {
            nums[card.number]++;
        }

        for (int i = 1; i < 10; i++) {
            if (nums[i] == 3) {
                return i;
            }
        }
        return 0;
    }

    static int[] isTwoPair(Card[] cards) {
        int[] nums = new int[10];
        for (Card card : cards) {
            nums[card.number]++;
        }

        int[] pair = new int[2];
        int idx = 0;
        int cnt = 0;
        for (int i = 1; i < 10; i++) {
            if (nums[i] == 2) {
                pair[idx++] = i;
            }
        }
        return pair;
    }

    static int isPair(Card[] cards) {
        int[] nums = new int[10];
        for (Card card : cards) {
            nums[card.number]++;
        }

        for (int i = 1; i < 10; i++) {
            if (nums[i] == 2) {
                return i;
            }
        }
        return 0;
    }

    static class Card {
        String color;
        int number;

        Card(String color, int number) {
            this.color = color;
            this.number = number;
        }
    }
}
