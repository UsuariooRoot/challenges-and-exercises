const formLabels = Array.from(document.querySelectorAll('.form-control label'));

// Function to create a span with delay for each letter
const createSpanWithDelay = (letter, index) => {
  const span = document.createElement('span');
  span.textContent = letter;
  span.style.transitionDelay = `${index * 50}ms`;
  return span;
};

// Process each tag
formLabels.forEach(label => {
  const originalContent = label.textContent;
  label.textContent = ''; // clear original content

  // Create and add spans for each letter
  [...originalContent].forEach((letter, index) => {
    label.appendChild(createSpanWithDelay(letter, index));
  });
});