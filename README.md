# Code Kata: Game of Craps

This repository contains code developed during the [Pragmatic Unit Testing][#pragmatic-unit-testing-good-reads] Code Katas.

* [The Game of Craps problem definition][#game-craps-definition]
* [Pragmatic Unit Testing on Good Reads][#pragmatic-unit-testing-good-reads]

The only rule (for now) on this project is to learn! Sorry, there's a second rule: we'll need to create
[meaningful commit messages][#tim-pope-commit-messages].


## Requirements

* IntelliJ IDEA CE
* Java 8


## Building the project

On the command line, run:

    $ ./gradlew build
    $ ./gradlew buildComplete

The difference between the tasks is that the second will also generate a code coverage report and the API
documentation.

Check the `build/` directory after running one of these tasks.


## Running the tests

On the command line, run:

    $ ./gradlew test


## Playing Craps!

After building the project, run:

    $ java -cp build/classes/main gameofcraps.PlayCraps 1000


[#game-craps-definition]: docs/game-craps.pdf
[#pragmatic-unit-testing-good-reads]: https://www.goodreads.com/book/show/23333089-pragmatic-unit-testing-in-java-8-with-junit
[#tim-pope-commit-messages]: http://tbaggery.com/2008/04/19/a-note-about-git-commit-messages.html
