# AndroidRecipe: Runnables

## Overview
This recipe shows how to use Runnables to enforce synchronous execution of
code using an AlertDialog as an example. The entire project can be found as a
public repository on GitHub.
Often we encounter points in our programs where we want to execute code
synchronously (so one by one, waiting for the previous function). For example,
you might be waiting for a user input before continuing execution. While
Android usually gives us some way of implementing this code, the more we use
it, the more we repeat ourselves.
This recipe shows a workaround for synchronous execution of functions.

**This recipe has been created for credit in MIS270x at Worcester Polytechnic Institute.**
