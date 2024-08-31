# Markdown Formatter

## Overview

The `MarkdownFormatter` is a Java program that reads a markdown file, formats it by adding newlines around LaTeX math expressions enclosed in double dollar signs (`$$`), and writes the formatted content to a new file.

## Features

- Reads a markdown file from the specified path.
- Identifies LaTeX math expressions enclosed in `$$`.
- Adds newlines around these LaTeX math expressions.
- Writes the formatted content to a new file named `Tarea1Formatted.md`.

## Requirements

- Java Development Kit (JDK) 8 or higher.

## Usage

1. **Compile the Java program:**

    ```sh
    javac MarkdownFormatter.java
    ```

2. **Run the program:**

    ```sh
    java MarkdownFormatter <path_to_markdown_file>
    ```

    Replace `<path_to_markdown_file>` with the actual path to the markdown file you want to format.

## Example

Assume you have a markdown file named `example.md` with the following content:

```markdown
This is a sample markdown file.

$$
E = mc^2
$$

More text here.