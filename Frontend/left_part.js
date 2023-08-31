const leftContainer = document.querySelector('.left-side');
const leftFlashcardContainer = leftContainer.querySelector('.flashcard-container');
const leftFlashcards = leftFlashcardContainer.querySelectorAll('.flashcard');

for (let i = 1; i < leftFlashcards.length; i++) {
  const translateYValue = i * 10;
  const translateXValue = -20;
  leftFlashcards[i].style.transform = `translate(${translateXValue}%, -${translateYValue}%)`;
}
