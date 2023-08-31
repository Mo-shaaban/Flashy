// JavaScript code for the flash cards
const middleContainer = document.querySelector('.middle-side')
const flashcardContainer = middleContainer.querySelector('.flashcard-container');
const flashcard = flashcardContainer.querySelector('.flashcard');
const knowButton = flashcardContainer.querySelector('.know-button');
const dontKnowButton = flashcardContainer.querySelector('.dont-know-button');
const questionElement = flashcardContainer.querySelector('#question');
const answerElement = flashcardContainer.querySelector('#answer');

// Function to fetch words from an endpoint and update flash card content
async function fetchWordsAndUpdateFlashcard() {
  try {
    const response = await fetch('http://localhost:8080/word/newWords/1');
    if (!response.ok) {
      throw new Error('Failed to fetch data');
    }
    
    const data = await response.json();
    if (data.length < 50) {
      throw new Error('Insufficient data from the endpoint');
    }
    
    // Assuming the response data is an array of objects with 'german' and 'english' properties
    const words = data.slice(0, 50); // Take the first 50 words

    // Choose a random word from the fetched data
    const randomIndex = Math.floor(Math.random() * words.length);
    const selectedWord = words[randomIndex];

    // Update the flash card content
    questionElement.textContent = selectedWord.german;
    answerElement.textContent = selectedWord.english;
  } catch (error) {
    console.error('Error:', error);
  }
}

// Function to toggle between front and back of the flash card
function flipCard() {
  flashcard.classList.toggle('flipped');
}

// Function to handle "Know It" button click
function handleKnowButtonClick() {
  // Implement your logic here
  console.log('Know It clicked');
}

// Function to handle "Don't Know It" button click
function handleDontKnowButtonClick() {
  // Implement your logic here
  console.log('Don\'t Know It clicked');
}

// Add event listeners
flashcard.addEventListener('click', flipCard);
knowButton.addEventListener('click', handleKnowButtonClick);
dontKnowButton.addEventListener('click', handleDontKnowButtonClick);

// Fetch words and update flash card content when the page loads
document.addEventListener('DOMContentLoaded', fetchWordsAndUpdateFlashcard);
