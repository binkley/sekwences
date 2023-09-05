<a href="./LICENSE.md">
<img src="./images/public-domain.svg" alt="Public Domain"
align="right" width="20%" height="auto"/>
</a>

# Sekwences

[![build](https://github.com/binkley/sekwences/workflows/build/badge.svg)](https://github.com/binkley/sekwences/actions)
[![issues](https://img.shields.io/github/issues/binkley/sekwences.svg)](https://github.com/binkley/sekwences/issues/)
[![pull requests](https://img.shields.io/github/issues-pr/binkley/sekwences.svg)](https://github.com/binkley/sekwences/pulls)
[![vulnerabilities](https://snyk.io/test/github/binkley/sekwences/badge.svg)](https://snyk.io/test/github/binkley/sekwences)
[![license](https://img.shields.io/badge/license-Public%20Domain-blue.svg)](http://unlicense.org/)

Explore various math sequences in Kotlin.

## Build and try

To build, use `./mvnw clean verify`.
Try `./run` for a demonstration.

To build as CI would, use `./batect build`.
Try `./batect run` for a demonstration as CI would.

This project assumes JDK 17.
There are no run-time dependencies beyond the Kotlin standard library.

## Sequences

### "Flip-flop"

"Flip-flop" refers to a sequence defined as:

* Given non-negative integers
* Given an open boundary (cap) value, `M`
* Given a starting value (seed), `a1` less than `M`
* Given a function, `f`, such the next sequence value `f(current value)`.
  `f` is essentially a "fold left" function that starts with the initial seed
  value
* When the current sequence value exceeds the cap, subtract the _overage_
  from the cap; that is the next sequence value
* Stop when seeing a previously seen sequence value (you have found a loop)

This code explores `M` equal to 100, and `f` equal to `2X` (doubling the
previous value), and impact of adjusting `M` or `f`.

Questions to explore:
- Do all values result in cycles smaller than exhausting the entire range?
- What are distinct cycles sharing no values in common? These are orthogonal (in some sense)
- How does changing `M` change cycles?
- How does changing `f` change cycles?
- What minimizes or maximizes cycle lengths?
- Are there non-trivial isolated cycles that only repeat to themselves?
  (A trivial example is starting with `0` as a sequence seed and using `2x` as
  the function to compute the next sequence value.)
- What are restrictions on `f` to stay "close" within range?
  Should sequence expectations stay within some range?
  For example `e^x` blows up (exceeds expected bounds) but does produce a cycle

This sequence was a bedtime exercise akin to "counting sheep."

## Reading

- [_Inside Sequences: Create Your Own Sequence
  Operations_](https://typealias.com/guides/inside-kotlin-sequences/)
- [_On-Line Encyclopedia of Integer Sequences_](https://oeis.org/wiki/Main_Page)
