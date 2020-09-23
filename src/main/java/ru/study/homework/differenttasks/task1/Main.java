package ru.study.homework.differenttasks.task1;

import java.util.*;

public class Main {
    public static void main(String[] args) {

// 1. TASK 1
// Создать игру, в которой игроки могут выбирать различных по способностям персонажей, которые имеют разные виды атак.
// Типы персонажей: маг, воин
// Оба типа персонажей имеют базовую атаку. В дополнении к базовой маги имеют магическую атаку, а воины имеют силовую атаку.
// Создать иерархию интерфейсов для реализации этих атак.
// Создать два класса, описывающие мага и воина.
// Каждый персонаж должен иметь статус здоровья: FULL (полное), NORMAL (поврежден), DANGER (критическое) и NONE (отсутствие здоровья).
// Статусы реализовать с помощью ENUM. Можно добавить дополнительные поля, общие поля можно объединить в супреклассе, который можно сделать абстрактным.
//
// В игре каждый игрок по очереди выбирает персонажа (игроки могут выбрать выбирать как разных персонажей, так и одинаковых).
// После чего начинается дуэль. Игрок проигрывает, когда у его персонажа статус здоровья становится NONE.
// Можно добавить дополнительные атаки типа: заморозка (пропуск хода или несколько ходов), критический удар, броня и т.д.

        Random rnd = new Random();

        int baseAttack = 20;
        int additionalAttack = rnd.nextInt(4) + 1;

        Player warrior = new Warrior("warrior", baseAttack);
        Player warriorAdditional = new Warrior("warrior", baseAttack, additionalAttack);
        Player wizard = new Wizard("wizard", baseAttack);
        Player wizardAdditional = new Wizard("wizard", baseAttack, additionalAttack);

        List<Player> players = Arrays.asList(warrior, wizard, warriorAdditional, wizardAdditional);
        for (Player p : players) {
            p.attack();
        }
    }
}
